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

        Log.d(TAG,"Before runBlocking")
        runBlocking {
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG,"Finished IO Coroutine")
            }
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG,"Finished IO Coroutine 2")
            }
            Log.d(TAG,"start of runBlocking")
            delay(2000L)
            Log.d(TAG,"End of runBlocking")
        }
        /*Log.d(TAG,"start of runBlocking")
        Thread.sleep(5000L)
        Log.d(TAG,"End of runBlocking")*/
        Log.d(TAG,"After runBlocking")
    }

}