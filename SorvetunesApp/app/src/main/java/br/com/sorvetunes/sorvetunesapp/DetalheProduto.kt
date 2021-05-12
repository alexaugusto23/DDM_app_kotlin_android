package br.com.sorvetunes.sorvetunesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe_produto.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_produtos.*
import kotlinx.android.synthetic.main.activity_produtos.menu_lateral
import kotlinx.android.synthetic.main.toolbar.*

class DetalheProduto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_produto)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Produtos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var produto = intent.getSerializableExtra("produto") as Produtos

        campo_nome.text = produto.nome
        campo_descricao.text = produto.descricao
        campo_valor_produto.text = produto.valor

        Picasso.with(this).load(produto.foto).fit().into(image_produto)


    }


}