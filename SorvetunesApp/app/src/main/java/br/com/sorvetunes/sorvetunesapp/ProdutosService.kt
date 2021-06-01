package br.com.sorvetunes.sorvetunesapp

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object ProdutosService {

    val host = "https://fesousa.pythonanywhere.com"
    val TAG = "APP_SOVERTUNES"

    fun getById(id: Int): Produtos {
        val url = "$host/disciplinas/$id"
        val json = HttpHelper.get(url)
        return parserJson(json)
    }

    fun getProdutos(): List<Produtos>{

//        val url = "$host/disciplinas"
//        val json = HttpHelper.get(url)
//        Log.d(TAG, json)
//
//        var produtos = parserJson<ArrayList<Produtos>>(json)

        val dao = DatabaseManager.getProdutosDAO()
        val produtos = dao.findAll()

        return produtos
    }

    fun saveProduto(produtos: Produtos){
//        val json = produtos.toJson()
//        HttpHelper.post("$host/disciplinas", json)
        val dao = DatabaseManager.getProdutosDAO()
        dao.insert(produtos)
        //return
    }

    inline fun < reified T> parserJson(json: String):T{

        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}