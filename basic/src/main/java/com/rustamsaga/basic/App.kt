package com.rustamsaga.basic

import android.app.Application
import android.content.Context


class App: Application() {
    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
        get() = checkNotNull(_appComponent) {
            "appComponent isn't initialized"
        }

    override fun onCreate() {
        super.onCreate()
//        _appComponent = DaggerAppComponent.create()
    }
}
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }