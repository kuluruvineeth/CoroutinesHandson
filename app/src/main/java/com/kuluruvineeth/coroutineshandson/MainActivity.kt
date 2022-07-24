package com.kuluruvineeth.coroutineshandson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                val answer1 = async{networkCall1()}
                val answer2 = async{networkCall2()}
                Log.d(TAG,"Answer1 is ${answer1.await()}")
                Log.d(TAG,"Answer2 is ${answer2.await()}")
            }
            Log.d(TAG,"Time taken $time")
        }

    }
    suspend fun networkCall1(): String {
        delay(3000)
        return "Answer 1"
    }

    suspend fun networkCall2(): String{
        delay(3000)
        return "Answer 2"
    }

}