package com.kuluruvineeth.coroutineshandson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnStartActivity)

        button.setOnClickListener{
            /*GlobalScope.launch {
                while(true){
                    delay(1000)
                    Log.d(TAG,"Still running....")
                }
            }*/
            lifecycleScope.launch {
                while(true){
                    delay(1000)
                    Log.d(TAG,"Still running1....")
                }
            }
            GlobalScope.launch {
                delay(5000)
                Intent(this@MainActivity,SecondActivity::class.java).also{
                    startActivity(it)
                    finish()
                }
            }
        }
    }

}