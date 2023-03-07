package com.ninja.understandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LiveMutableDataActivity : AppCompatActivity() {
    private var mCounter = 0
    private val mCounterMutableLiveData: MutableLiveData<Int> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        getCountLiveData().observe(this){
            Toast.makeText(this,"Value is ${it}",Toast.LENGTH_LONG).show()
        }
    }

    fun IncrementCounter(view: View) {
        mCounter++;
        mCounterMutableLiveData.value = mCounter
    }

    private fun getCountLiveData(): LiveData<Int> = mCounterMutableLiveData


}