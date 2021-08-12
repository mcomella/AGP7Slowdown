package org.mozilla.agp7slowdown

import android.app.Application
import android.content.Context
import android.os.Debug
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        Debug.startMethodTracingSampling("startup", 0, 1000)
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        GlobalScope.launch(Dispatchers.Main) {
            android.util.Log.e("agp", "this line doesn't matter")
        }
    }
}