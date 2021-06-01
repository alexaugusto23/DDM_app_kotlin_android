package br.com.sorvetunes.sorvetunesapp

import android.app.Application

class SorvetunesApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: SorvetunesApplication? = null

        fun getInstance(): SorvetunesApplication {
            if (appInstance == null) {
                 throw IllegalMonitorStateException("Configurar application no Manifest")
             }
            return appInstance!!
        }
    }
}