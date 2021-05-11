package br.com.sorvetunes.sorvetunesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class PedidosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)

        supportActionBar?.title = "Pedidos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //menu_lateral.setCheckedItem(R.id.nav_pedidos)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }


        return super.onOptionsItemSelected(item)
    }
}