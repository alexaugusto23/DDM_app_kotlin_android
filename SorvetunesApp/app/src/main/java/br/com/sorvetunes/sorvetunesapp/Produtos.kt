package br.com.sorvetunes.sorvetunesapp

import java.io.Serializable

class Produtos: Serializable {
    var id: Long = 0
    var nome = ""
    var descricao = ""
    var foto = ""
    var valor = ""
}