package com.example.geez.model.service

import com.example.geez.model.RegisterResponse
import com.example.geez.model.UserRespons
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


private const val BASE_URL = "http://52.7.48.144:3000/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(Gson()))
    .baseUrl(BASE_URL)
    .build()

interface AuthApiService {
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): UserRespons

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("password") password: String
    ): RegisterResponse
}

object AuthApi {
    val retrofitService: AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }
}