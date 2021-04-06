package br.com.sorvetunes.sorvetunesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.login.*
import android.widget.Toast

class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        imageview_login.setImageResource(R.drawable.img_sorvete_01)

        botao_login.setOnClickListener{
            val user  = input_user.text.toString()
            val password = input_password.text.toString()
            if (user.equals("") && password.equals("")){
                Toast.makeText(this, "Usuário e Senha vazios, digite um valor válido para realizar Login !", Toast.LENGTH_LONG).show()
            } else{Toast.makeText(this, "Clicou no Login", Toast.LENGTH_LONG).show() }

        }
    }

}