package ru.example.mobile.hhclone

import android.app.Application
import ru.example.mobile.hhclone.di.DI
import org.koin.android.ext.koin.androidContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DI.setupKoin {
            androidContext(applicationContext)
        }
    }

}