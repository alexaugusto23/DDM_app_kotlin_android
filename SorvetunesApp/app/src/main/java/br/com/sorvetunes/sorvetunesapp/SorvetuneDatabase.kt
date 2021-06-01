package br.com.sorvetunes.sorvetunesapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities =  arrayOf(Produtos::class), version=1)
abstract  class SorvetuneDatabase: RoomDatabase(){
    abstract fun produtoDAO(): ProdutoDAO
}
