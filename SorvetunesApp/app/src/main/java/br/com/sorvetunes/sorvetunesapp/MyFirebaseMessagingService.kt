package br.com.sorvetunes.sorvetunesapp

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
// Token: emHouQk0OSk:APA91bHGvMtD2TDeqsOCoYd42rnHLZcOg-9N1ugSVBYwWIA8Odtc7QMyiLLLPl2trJqtkH571LXSk2OLu_jldJBDeuacZx8Bhy0_xLkQHGLBDEV4CkYYPuMQ9_XKH6fyuvb9OfLVBhTT
class MyFirebaseMessagingService: FirebaseMessagingService() {

    val TAG = "SOVERTUNES_FB"

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "TOKEN_FB $token")

        Prefs.setString("TOKEN_FB", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?){
        super.onMessageReceived(mensagemRemota)

        if(mensagemRemota?. notification != null){
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Título: $titulo")
            Log.d(TAG, "Corpo: $corpo")

            if(mensagemRemota?.data.isNotEmpty()){
                val produtosID = mensagemRemota.data.get("produtosId")
                Log.d(TAG,"Id da Disciplina $produtosID")
                val d = ProdutosService.getById(produtosID!!.toInt())

                val intent = Intent(this, ProdutosActivity::class.java)
                intent.putExtra("produtos", d)
                NotificationUtil.create(1, intent, titulo!!, corpo!!)
            }

        }


    }

}