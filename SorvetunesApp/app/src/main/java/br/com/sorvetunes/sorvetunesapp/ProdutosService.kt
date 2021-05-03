package br.com.sorvetunes.sorvetunesapp

object ProdutosService {

    fun getProdutos(): List<Produtos>{

        val produtos = mutableListOf<Produtos>()
        for (i in 1..10){
            val d = Produtos()
            d.nome = "Produto $i"
            d.descricao = "Descrição $i"
            d.valor = "Valor $i"
            d.foto = "https://www.google.com/search?q=sorvetes&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjVguSf-azwAhUGEbkGHW8fBh0Q_AUoAXoECAIQAw&biw=948&bih=603#imgrc=SQNkjEkOYDIFsM"

            produtos.add(d)
        }
        return  produtos
    }
}