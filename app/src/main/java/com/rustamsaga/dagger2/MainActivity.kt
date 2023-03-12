package com.rustamsaga.dagger2

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javax.inject.Inject

class MainApp: Application() {

    private var _appComponent : APpComponent? = null

    internal val appComponent: APpComponent
        get() = checkNotNull(_appComponent) {
            "appComponent isn't initialized"
        }

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAPpComponent.create()
    }
}

val Context.appComponent: APpComponent
    get() = when(this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var computer: Computer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val computer: Computer = appComponent.computer

        appComponent.injectMainActivity(this)

        Log.d("Computer - MainActivity", "$computer")
    }
}