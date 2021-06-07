package br.com.sorvetunes.sorvetunesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_adiciona_produto.*

class AdicionaProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adiciona_produto)

        supportActionBar?.title = "Adicionar"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        salvar_produto.setOnClickListener {
            val produtos = Produtos()
            produtos.nome = editText_nome.text.toString()
            produtos.descricao = editText_descricao.text.toString()
            produtos.foto = editText_foto.text.toString()
            produtos.valor = editText_valor.text.toString()

            taskAtualizar(produtos)
        }

    }
    //

    private fun taskAtualizar(produtos: Produtos) {
        // Thread para salvar a produto
        Thread {
            ProdutosService.saveProduto(produtos)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }


        return super.onOptionsItemSelected(item)
    }


}