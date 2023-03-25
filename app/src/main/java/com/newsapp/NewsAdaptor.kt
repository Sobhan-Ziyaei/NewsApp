package com.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.LayoutInflaterCompat
import androidx.recyclerview.widget.RecyclerView

//هر زمان یک Recycler View ساختیم نیاز به دو کلاس Adaptor و ViewHolder داریم
class NewsAdaptor(var newsList: MutableList<News>) :
    RecyclerView.Adapter<NewsAdaptor.ViewHolder>() {
    //ViewHolder -> inner Class and extends RecyclerView.ViewHolder(view)
    //وظیفه کلاس viewHolder این است که مواردی را که در Recycler View تعریف کردیم را مقداردهی یا initialize بکند

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val description: TextView
        val dateAndWriter: TextView
        val image: ImageView

        //هر کلاسی در کاتلین دستوری به نام init دارد این دستور زمانی که ما آبجکت از کلاس بسازیم یکبار اجرا میشود و موارد داخل بلاکش را فرا میخواند
        init {
            view.apply {
                title = findViewById(R.id.titleText)
                description = findViewById(R.id.descriptionText)
                dateAndWriter = findViewById(R.id.dateAndWriterText)
                image = findViewById(R.id.imageView)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_schema, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            title.text = newsList[position].title
            description.text = newsList[position].description
            dateAndWriter.text = newsList[position].description + " " + newsList[position].writer

        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}