package com.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val newsList = mutableListOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialRecView()
        //LifecycleScope is optimize because it is run until activity does not destroy so fill not the RAM
        lifecycleScope.launch {

        }
    }

    private fun initialRecView() {
        val recView = findViewById<RecyclerView>(R.id.recView)
        val newsAdapter = NewsAdaptor(newsList,this)
        recView.adapter = newsAdapter
        recView.layoutManager = LinearLayoutManager(this)
    }

    private suspend fun networkCall(): String {
        delay(2000)
        return "ali"
    }
}