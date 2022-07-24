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

        val job = GlobalScope.launch(Dispatchers.Default) {
            /*repeat(5){
                Log.d(TAG,"Coroutine is still working.....")
                delay(1000)
            }*/
            Log.d(TAG,"Starting long running calculation...")
            withTimeout(3000){
                for(i in 30..50){
                    if(isActive){
                        Log.d(TAG,"Result for i = $i: ${fib(i)}")
                    }
                }
            }
            Log.d(TAG,"Ending long running calculation...")
        }

        /*runBlocking {
            delay(2000)
            job.cancel() //cancel the job
            //job.join() //waiting till this job gets completed
            Log.d(TAG,"Cancelled job..")
        }*/
    }

    fun fib(n: Int): Long {
        return if(n==0) 0
        else if(n==1) 1
        else fib(n-1) + fib(n-2)
    }

}