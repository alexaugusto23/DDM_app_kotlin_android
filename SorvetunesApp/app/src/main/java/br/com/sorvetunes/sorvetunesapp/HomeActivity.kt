package br.com.sorvetunes.sorvetunesapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*


class HomeActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val args = intent.extras
        val usuario = args?.getString("usuario")
        val numero = args?.getString("senha")

        Toast.makeText(this, usuario, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, numero, Toast.LENGTH_SHORT).show()

        user_home.setText("Olá $usuario")

        button_home.setOnClickListener{
            var intent_home = Intent(this, MainActivity::class.java)
            startActivity(intent_home)
        }
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)

        (menu?.findItem(R.id.nav_bar_search)?.actionView as SearchView?)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextChange(newText: String): Boolean {
                    // ação enquanto está digitando
                    return false
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    // ação  quando terminou de buscar e enviou
                    return false
                }

            })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if ( id == R.id.nav_bar_search){}
        else if (id == R.id.nav_bar_add) {}
        else if (id == R.id.nav_bar_update) {}
        else if (id == R.id.nav_bar_config) {
            var intent_config = Intent(this, ConfigActivity::class.java)
            startActivity(intent_config)
        }
        else if (id == android.R.id.home) {
            finish()
            //var intent_config = Intent(this, MainActivity::class.java)
            //startActivity(intent_config)
        }

        when (item.itemId){
            R.id.nav_bar_search -> Toast.makeText(this, "pesquisar", Toast.LENGTH_SHORT).show()
            R.id.nav_bar_add -> Toast.makeText(this, "adicionar", Toast.LENGTH_SHORT).show()
            R.id.nav_bar_update -> Toast.makeText(this, "atualizar", Toast.LENGTH_SHORT).show()
            R.id.nav_bar_config -> Toast.makeText(this, "atualizar", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}