import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geez.R

@Preview
@Composable
fun Onboarding() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffF9FAFB))
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle_onboarding),
            contentDescription = "",
            modifier = Modifier
                .offset(x = 171.dp, y = 64.dp)
                .size(160.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(83.dp))
            Text(
                text = "Let’s start sharing with arround you!",
                modifier = Modifier
                    .padding(start = 40.dp)
                    .width(215.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W800,
                )
            )
            Image(
                painter = painterResource(id = R.drawable.onboarding),
                contentDescription = "onboarding image",
                modifier = Modifier.size(412.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF449EEE)),
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                ) {
                    Text(text = "Login", fontSize = 14.sp, fontWeight = FontWeight.W800)
                }
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedButton(
                    onClick = { },
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    border = BorderStroke(
                        1.dp, color = Color(0xff449EEE),
                    )
                ) {
                    Text(
                        text = "Register",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W800,
                        color = Color(0xff449EEE)
                    )
                }
            }
        }
    }
}