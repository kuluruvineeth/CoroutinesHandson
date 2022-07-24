package com.kuluruvineeth.coroutineshandson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            delay(5000)
            Log.d(TAG,"Coroutine says hello from thread ${Thread.currentThread().name}")
        }
        Log.d(TAG,"hello from thread ${Thread.currentThread().name}")
    }
}