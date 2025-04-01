package com.rick.workclass.ejemplo.com.example.example1.data.Network

import com.google.gson.JsonObject
import com.rick.workclass.ejemplo.com.example.example1.data.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("user")
    suspend fun login(@Body user:UserModel):Response<JsonObject>
}