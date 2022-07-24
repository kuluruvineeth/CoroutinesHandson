package com.kuluruvineeth.coroutineshandson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tvDummy = findViewById<TextView>(R.id.tvDummy)

        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG,"Starting coroutine in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main){
                Log.d(TAG,"Starting main thread ${Thread.currentThread().name}")
                tvDummy.text = answer
            }
        }

    }

    suspend fun doNetworkCall(): String{
        delay(2000)
        return "This is the customized suspend function"
    }
}