package com.ninja.understandlivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun liveData(view: View) {
        val intent = Intent(this,LiveMutableDataActivity::class.java)
        startActivity(intent)
    }

    fun MediatorLiveData(view: View) {
        val intent = Intent(this,MediatorLiveDataActivity::class.java)
        startActivity(intent)
    }

    fun liveDataWithList(view: View) {
        val intent = Intent(this,LiveMutableDataListActivity::class.java)
        startActivity(intent)
    }
}