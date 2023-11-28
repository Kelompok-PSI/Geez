package com.example.geez.model.service

import HistoryResp
import com.example.geez.model.CampaignDetailResp
import com.example.geez.model.CampaignResponse
import com.example.geez.model.CoordinateBody
import com.example.geez.model.Donation
import com.example.geez.model.NearestCampaignResp
import com.example.geez.model.RegisterResponse
import com.example.geez.model.UserRespons
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


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

interface CampaignApiService {
    @GET("campaign")
    suspend fun getAllCampaigns(@Header("Authorization") token: String): CampaignResponse

    @GET("campaign/nearest")
    suspend fun getNearestCampaign(
        @Header("Authorization") token: String,
        @Query("latitude") latitude: Double?,
        @Query("longitude") longitude: Double?,
    ): NearestCampaignResp

    @GET("campaign/{campaignId}")
    suspend fun getDetailCampaign(
        @Header("Authorization") token: String,
        @Path("campaignId") campaignId: String
    ): CampaignDetailResp

    @POST("donate")
    suspend fun donate(
        @Header("Authorization") token: String,
        @Body donationData: Donation
    ): CampaignDetailResp
}

interface HistoryApiService {
    @GET("history")
    suspend fun getALlHistory(
        @Header("Authorization") token: String
    ): HistoryResp
}


object ApiService {
    val retrofitService: AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }
    val campaignService: CampaignApiService by lazy {
        retrofit.create(CampaignApiService::class.java)
    }
    val historyService: HistoryApiService by lazy {
        retrofit.create(HistoryApiService::class.java)
    }
}

object AuthApi {
    val retrofitService: AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }
}