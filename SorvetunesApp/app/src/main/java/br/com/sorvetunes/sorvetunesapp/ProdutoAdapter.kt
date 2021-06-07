package br.com.sorvetunes.sorvetunesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.sorvetunes.sorvetunesapp.HttpHelper.get
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get

class ProdutoAdapter (
    val produtos: List<Produtos>,
    val onclick: (Produtos) -> Unit
    ) : RecyclerView.Adapter<ProdutoAdapter.ProdutosViewHolder>() {

    class  ProdutosViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
        val cardProcess: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
            cardProcess = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_produtos)
        }
    }

    override fun getItemCount()  = this.produtos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produto, parent, false)
        val holder = ProdutosViewHolder(view)
        return  holder
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produto = this.produtos[position]

        holder.cardNome.text = produto.nome
        holder.cardProcess.visibility = View.VISIBLE

        val contexto = holder.itemView.context

        Picasso.with(contexto).load(produto.foto).fit().into(holder.cardImg,
                object : com.squareup.picasso.Callback {
                    override fun onSuccess() {
                        holder.cardProcess.visibility = View.GONE
                    }

                    override fun onError() {
                        holder.cardProcess.visibility = View.GONE
                        holder.cardImg.setImageResource(R.drawable.img_sorvete_03)
                    }
                }
            )

        holder.itemView.setOnClickListener { onclick(produto) }


    }

}
