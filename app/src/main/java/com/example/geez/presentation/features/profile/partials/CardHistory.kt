import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.geez.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.geez.lib.convertDateFormat

@Composable
fun CardHistory(data: History) {
    Column(
        modifier = Modifier.background(
            color = Color.White,
        ).padding(bottom = 12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "dummypict",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
        )
        Column(modifier = Modifier.padding(16.dp, 12.dp)) {
            Text(
                text =  data.campaign.name,
                style = TextStyle(
                    color = Color(0xff1C222B),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                ),
            )
            Text(
                text = "Foodname: ${data.food}",
                style = TextStyle(
                    color = Color(0xff1C222B),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                ),
            )
            Text(
                text = "Quantity: ${data.quantity}",
                style = TextStyle(
                    color = Color(0xff1C222B),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                ),
                modifier = Modifier.padding(bottom = 9.dp)
            )
            Row (verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.clarity_date_line),
                    contentDescription = "tanggal"
                )
                Text(
                    text = data.date.split("T")[0],
                    style = TextStyle(
                        color = Color(0xff8897AE),
                        fontSize = 8.sp,
                        fontWeight = FontWeight.W600
                    ),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}