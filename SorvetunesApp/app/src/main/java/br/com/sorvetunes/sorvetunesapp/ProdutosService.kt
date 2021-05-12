package br.com.sorvetunes.sorvetunesapp

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object ProdutosService {

    val host = "https://fesousa.pythonanywhere.com"
    val TAG = "APP_SOVERTUNES"

    fun getProdutos(): List<Produtos>{

        val url = "$host/disciplinas"
        val json = HttpHelper.get(url)
        Log.d(TAG, json)

        var produtos = parserJson<ArrayList<Produtos>>(json)

        return  produtos
    }

    fun saveProduto(produtos: Produtos){
        val json = produtos.toJson()
        HttpHelper.post("$host/disciplinas", json)
        return 
    }

    inline fun < reified T> parserJson(json: String):T{

        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}