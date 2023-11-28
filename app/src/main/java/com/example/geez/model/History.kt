import com.google.gson.annotations.SerializedName

data class History(
    val id: Int,
    @SerializedName("user_id") val userId: Int,
    @SerializedName("campaign_id") val campaignId: Int,
    val food: String,
    val quantity: Int,
    val expireedDate: String,
    val pickupLocation: String,
    val date: String,
)

data class HistoryResp(
    val data: List<History> = emptyList()
)