import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geez.R

@Composable
fun HelpCenter() {
    val bTextStyle = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.W600,
        color = Color(0xff1C222B),
    )

    return Column() {
        Text(
            text = "Help Center",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W800,
                color = Color(0xff1C222B)
            ),
            modifier = Modifier.padding(bottom = 8.dp, top = 24.dp)
        )
        Column(
            modifier = Modifier
                .padding(vertical = 2.dp, horizontal = 12.dp)
                .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.cs),
                        contentDescription = "",
                        modifier = Modifier.padding(end = 18.dp).size(18.dp),
                    )
                    Text(text = "Customer Help Center", style = bTextStyle)
                }
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = null, // Add appropriate content description
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
            Divider(thickness = 1.dp, color = Color(0xff8897AE))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.faq),
                        contentDescription = "",
                        modifier = Modifier.padding(end = 18.dp).size(18.dp),
                    )
                    Text(text = "Frequently Ask Question", style = bTextStyle)
                }
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = null, // Add appropriate content description
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
            Divider(thickness = 1.dp, color = Color(0xff8897AE))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.language),
                        contentDescription = "",
                        modifier = Modifier.padding(end = 18.dp).size(18.dp),
                    )
                    Text(text = "Change Language", style = bTextStyle)
                }
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = null, // Add appropriate content description
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}