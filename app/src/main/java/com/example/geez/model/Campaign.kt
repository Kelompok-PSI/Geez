package com.example.geez.model


data class Campaign(
    val id: String,
    val name: String,
    val img: String,
    val reached: Int,
    val target: Int,
    val deadline: String,
    val description: String
)

data class CampaignResponse(
    val data: List<Campaign> = emptyList()
)

data class NearestCampaignResp(
    val data: SortedCampaign
)

data class SortedCampaign(
    val sortedCampaigns: List<Campaign> = emptyList()
)

data class CampaignDetail(
    val id: String,
    val name: String,
    val img: String,
    val reached: Int,
    val location: String,
    val rules: String = "Init rules yang pasti ada",
    val target: Int,
    val deadline: String,
    val startFromIdr: String,
    val description: String,
    val specificFood: String
)

data class CampaignDetailResp(
    val data: CampaignDetail
)

data class CoordinateBody(
    val longitude: Double,
    val altitude: Double
)
