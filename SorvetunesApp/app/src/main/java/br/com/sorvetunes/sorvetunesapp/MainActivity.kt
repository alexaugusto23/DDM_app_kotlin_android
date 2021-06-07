package br.com.sorvetunes.sorvetunesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast

class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        input_user.setText(Prefs.getString("nome_usuario"))
        input_password.setText(Prefs.getString("senha"))
        campo_check.isChecked = (Prefs.getBoolean("campo_check"))

        imageview_login.setImageResource(R.drawable.img_sorvete_01)

        botao_login.setOnClickListener{onClickLogin()}

    }

    fun onClickLogin() {

        val user  = input_user.text.toString()
        val password = input_password.text.toString()
        val valorCheck = campo_check.isChecked

        Prefs.setBoolean("campo_check", valorCheck)

        if(valorCheck){
            Prefs.setString("nome_usuario", user)
            Prefs.setString("senha", password)
        } else {
            Prefs.setString("nome_usuario", "")
            Prefs.setString("senha", "")
        }

        //Prefs.setString("nome_usuario", user)

        var intent = Intent(this, HomeActivity::class.java)
        var parametros = Bundle()
        parametros.putString("usuario", user)
        parametros.putString("senha", password)
        if (user.equals("") && password.equals("")){
            Toast.makeText(this, "Usuário e Senha vazios, digite um valor válido para realizar Login !", Toast.LENGTH_LONG).show()
        } else if (user.equals("sorvetunes") && password.equals("sorvete")){
            Toast.makeText(this, "Login Efetuado!", Toast.LENGTH_SHORT).show()
            intent.putExtras(parametros)
            //intent.putExtra("double", 1.75)
            startActivity(intent)
        } else{Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show() }

    }

}