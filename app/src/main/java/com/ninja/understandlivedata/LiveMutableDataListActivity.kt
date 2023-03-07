package com.ninja.understandlivedata

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class LiveMutableDataListActivity : AppCompatActivity() {

    private lateinit var viewModel: LiveMutableDataListActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_mutable_data_list)
        val listView = findViewById<ListView>(R.id.list) as ListView
        val progressBar = findViewById<ProgressBar>(R.id.progressbar) as ProgressBar
        progressBar.visibility = View.VISIBLE

        viewModel = ViewModelProvider(this).get(LiveMutableDataListActivityViewModel::class.java)

        viewModel.getFruitList()?.observe(this){fruitlist ->
            // update UI
            val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
                this,
                android.R.layout.simple_list_item_1, android.R.id.text1, fruitlist
            )
            // Assign adapter to ListView
            listView.adapter = adapter
            progressBar.visibility = View.GONE
        }
    }
}