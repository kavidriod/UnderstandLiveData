package com.ninja.understandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

class MediatorLiveDataActivity : AppCompatActivity() {

    private var mCounter = 0
    private var mCounter2 = 0

    private val mFirstMutableLiveData: MutableLiveData<Int> =  MutableLiveData()
    private val mSecondMutableLiveData: MutableLiveData<Int> =  MutableLiveData()
    private val mMediatorLiveData: MediatorLiveData<Int> = MediatorLiveData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mediator_live_data)

        mMediatorLiveData.addSource(mFirstMutableLiveData){
            mMediatorLiveData.value = it
        }

        mMediatorLiveData.addSource(mSecondMutableLiveData){
            mMediatorLiveData.value = it
        }

        mMediatorLiveData.observe(this){
            Toast.makeText(this,"Value is ${it}", Toast.LENGTH_LONG).show()
        }
    }

    fun IncrementCounter2(view: View) {
        mCounter2++;
        mSecondMutableLiveData.value = mCounter2
    }


    fun IncrementCounter1(view: View) {
        mCounter++;
        mFirstMutableLiveData.value = mCounter
    }
}