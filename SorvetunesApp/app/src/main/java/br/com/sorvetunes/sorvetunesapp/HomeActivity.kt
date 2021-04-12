package br.com.sorvetunes.sorvetunesapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.nav_menu, menu)

        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.nav_bar_search)
        val searchView = searchItem?.actionView as SearchView

        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("", false)
                searchItem.collapseActionView()
                Toast.makeText(this@HomeActivity, "Procurando por $query", Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(this@HomeActivity, "Procurando por $newText", Toast.LENGTH_SHORT).show()
                return true
            }
        })

        return true
    }
}