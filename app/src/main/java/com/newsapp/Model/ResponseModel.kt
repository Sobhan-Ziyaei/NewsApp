package com.newsapp.Model

class ResponseModel(
    var status: String,
    var totalResults: Int,
    var articles: List<News>
) {

}