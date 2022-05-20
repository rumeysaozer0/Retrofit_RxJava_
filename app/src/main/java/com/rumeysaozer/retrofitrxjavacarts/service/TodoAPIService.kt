package com.rumeysaozer.retrofitrxjavacarts.service

import com.rumeysaozer.retrofitrxjavacarts.model.Todos
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class TodoAPIService {
    private val BASE_URL = "https://dummyjson.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(TodoAPI::class.java)
    fun getDatas(): Single<Todos>{
        return api.getData()
    }
}