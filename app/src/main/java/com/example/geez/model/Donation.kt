package com.example.geez.model

import com.google.gson.annotations.SerializedName

data class Donation(
    @SerializedName("campaign_id") val campaignId: Int,
    val food: String,
    val quantity: Int,
    @SerializedName("expiredDate") val expiredDate: String,
    @SerializedName("pickupLocation") val pickupLocation: String
)
