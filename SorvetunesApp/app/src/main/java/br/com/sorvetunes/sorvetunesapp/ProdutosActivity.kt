package br.com.sorvetunes.sorvetunesapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.button_home
import kotlinx.android.synthetic.main.activity_home.layoutMenuLateral
import kotlinx.android.synthetic.main.activity_home.menu_lateral
import kotlinx.android.synthetic.main.activity_produtos.*
import kotlinx.android.synthetic.main.toolbar.*
import okio.Utf8.size

class ProdutosActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)

        val intent_voltar_home = Intent(this, HomeActivity::class.java)

        button_voltar_para_home.setOnClickListener{
            startActivity(intent_voltar_home)
        }

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Produtos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()
        recycleProdutos?.layoutManager = LinearLayoutManager(this)
        recycleProdutos?.itemAnimator = DefaultItemAnimator()
        recycleProdutos?.setHasFixedSize(true)
        menu_lateral.setCheckedItem(R.id.nav_produtos)
    }

    override fun onResume() {
        super.onResume()
        taskProdutos()
    }

    private var produtos = listOf<Produtos>()

    private fun taskProdutos(){

        Thread {
            this.produtos = ProdutosService.getProdutos()

            runOnUiThread {
                recycleProdutos?.adapter = ProdutoAdapter(produtos) {onClickProduto(it)}

            val intent = Intent(this, ProdutosActivity::class.java)
            intent.putExtra("produto", produtos[0])
            NotificationUtil.create(1, intent,"SorvetunesApp", "Você tem um novo produto ${produtos[0].nome}")
            }
        }.start()

    }

    fun onClickProduto(produto: Produtos){
        Toast.makeText(this, "Clicou no produto! ${produto.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent( this, DetalheProduto::class.java)
        intent.putExtra("produto", produto)
        startActivity(intent)
    }


    private fun configuraMenuLateral(){
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
//            R.id.nav_admin ->{
//                var intent_admin = Intent(this, AdminActivity::class.java)
//                startActivity(intent_admin)
//                Toast.makeText(this, "Clicou no Admin", Toast.LENGTH_SHORT).show()}

            R.id.nav_produtos -> {
                var intent_produtos = Intent(this, ProdutosActivity::class.java)
                startActivity(intent_produtos)
                Toast.makeText(this, "Clicou no Produto", Toast.LENGTH_SHORT).show()
            }

//            R.id.nav_pedidos -> {
//                var intent_pedidos = Intent(this, PedidosActivity::class.java)
//                startActivity(intent_pedidos)
//                Toast.makeText(this, "Clicou no Pedido", Toast.LENGTH_SHORT).show()
//            }

        }

        layoutMenuLateral.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }


        return super.onOptionsItemSelected(item)
    }
}