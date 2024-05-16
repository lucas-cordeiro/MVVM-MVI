package br.com.lucascordeiro.mvvm_mvi

import android.app.Application
import br.com.lucascordeiro.mvvm_mvi.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(AppModules.modules)
        }
    }
}