package br.com.sorvetunes.sorvetunesapp

import com.google.gson.GsonBuilder
import java.io.Serializable

class Produtos: Serializable {
    var id: Long = 0
    var nome = ""
    var descricao = ""
    var foto = ""
    var valor = ""

    override fun toString(): String {
        return "Produto(nome= $nome)"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }

}