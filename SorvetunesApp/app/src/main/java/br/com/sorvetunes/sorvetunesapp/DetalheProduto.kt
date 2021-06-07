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
import okhttp3.internal.http.RequestLine.get

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
        var url = produto.foto

        Picasso.with(this).load(url).fit().into(image_produto)


    }


}