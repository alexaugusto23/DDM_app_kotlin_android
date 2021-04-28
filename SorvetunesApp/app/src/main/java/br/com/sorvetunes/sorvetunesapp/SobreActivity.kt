package br.com.sorvetunes.sorvetunesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.toolbar.*

class SobreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Sobre"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }


        return super.onOptionsItemSelected(item)
    }
}
