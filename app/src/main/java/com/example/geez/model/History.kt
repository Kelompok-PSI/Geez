import com.example.geez.model.CampaignDetail
import com.google.gson.annotations.SerializedName

data class History(
    val id: Int,
    @SerializedName("user_id") val userId: Int,
    @SerializedName("campaign_id") val campaignId: Int,
    val food: String,
    val quantity: Int,
    val expiredDate: String,
    val pickupLocation: String,
    val date: String,
    val campaign: CampaignDetail,
)

data class HistoryResp(
    val data: List<History> = emptyList()
)