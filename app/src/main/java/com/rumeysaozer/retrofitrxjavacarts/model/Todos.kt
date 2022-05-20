package com.rumeysaozer.retrofitrxjavacarts.model


import com.google.gson.annotations.SerializedName

data class Todos(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("todos")
    val todos: List<Todo>,
    @SerializedName("total")
    val total: Int
)