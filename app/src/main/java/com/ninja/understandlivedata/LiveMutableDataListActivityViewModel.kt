package com.ninja.understandlivedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveMutableDataListActivityViewModel : ViewModel() {

    private var LogTag = LiveMutableDataListActivityViewModel::class.java.simpleName
    private var mFruits: MutableLiveData<List<String>>? = null

     fun getFruitList(): LiveData<List<String>>? {
        if (mFruits == null){
            mFruits = MutableLiveData()
            loadFruits()
        }
        return mFruits
    }

    private fun loadFruits() {
        val myHandler = android.os.Handler()
        myHandler.postDelayed({
            val fruitList = ArrayList<String>()

            fruitList.add("Mango")
            fruitList.add("Apple")
            fruitList.add("Guava")
            mFruits?.value = fruitList

        },5000)

    }

    override fun onCleared() {
        super.onCleared()
        Log.i(LogTag, "onCleared: ")
    }

}