package br.com.sorvetunes.sorvetunesapp

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: SorvetuneDatabase

    init{
        val context = SorvetunesApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            SorvetuneDatabase::class.java,
            "sorvetunes.sqlite"
        ).build()
    }
    fun getProdutosDAO(): ProdutoDAO {
        return  dbInstance.produtoDAO()
    }

}