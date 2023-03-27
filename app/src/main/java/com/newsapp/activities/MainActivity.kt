package com.newsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newsapp.API.API
import com.newsapp.Model.News
import com.newsapp.Adapter.NewsAdaptor
import com.newsapp.R
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val newsList = mutableListOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //LifecycleScope is optimize because it is run until activity does not destroy so fill not the RAM
        lifecycleScope.launch {
            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            progressBar.isVisible = true
            var response = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create()).build().create(API::class.java)
                .getNews("techcrunch", "eae0d22b8219486cb31c0390dc47a6a9")
            if (response.isSuccessful && response.body() != null) {
                newsList.addAll(response.body()!!.articles)
                initialRecView()
                progressBar.isVisible = false
            } else {
                Log.e("checkResponse", "nothing")
            }
        }
    }

    private fun initialRecView() {
        val recView = findViewById<RecyclerView>(R.id.recView)
        val newsAdapter = NewsAdaptor(newsList, this)
        recView.adapter = newsAdapter
        recView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recView.addItemDecoration(dividerItemDecoration)
    }
}