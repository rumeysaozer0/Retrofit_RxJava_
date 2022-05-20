package com.rumeysaozer.retrofitrxjavacarts.service


import com.rumeysaozer.retrofitrxjavacarts.model.Todos
import io.reactivex.Single
import retrofit2.http.GET

interface TodoAPI {
    @GET("todos")
    fun getData(): Single<Todos>
}