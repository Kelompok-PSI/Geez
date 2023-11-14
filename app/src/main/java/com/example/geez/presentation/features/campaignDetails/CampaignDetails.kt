package com.example.geez.presentation.features.campaignDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geez.R

@Composable
fun CampaignDetail() {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        item{
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 25.dp)) {
                Image(painter = painterResource(R.drawable.back), contentDescription = "Back")
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Campaign Details",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
        }
        item{
            Spacer(modifier = Modifier.height(15.dp))
            Image(
                painter = painterResource(id = R.drawable.image_1),
                contentDescription = "dummypict",
                contentScale = ContentScale.Fit,
                modifier = Modifier.clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
        item{
            CampaignDetailCard()
        }
        item {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Description",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed auctor quis sapien eu rutrum. " +
                        "Fusce vitae enim eget ipsum eleifend feugiat eu vel neque. Praesent sit amet justo magna. " +
                        "Sed aliquam nisl ut diam eleifend, id vehicula dolor vehicula. Praesent at ante ut sapien placerat dapibus in ut magna. " +
                        "Sed lacinia turpis vel neque efficitur mollis. Donec eget interdum ipsum. Vivamus euismod lorem sed consequat consectetur. " +
                        "Sed pretium nunc sit amet ante suscipit fringilla. Aliquam erat volutpat. Sed non arcu velit. Vivamus quis lectus eget nisi efficitur aliquam. " +
                        "Nullam sodales turpis id odio vulputate varius. Sed nec felis eu arcu convallis suscipit.",
                textAlign = TextAlign.Justify,
                fontSize = 15.sp
            )
            Text(
                text = "Specific Food",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed auctor quis sapien eu rutrum. " +
                        "Fusce vitae enim eget ipsum eleifend feugiat eu vel neque. Praesent sit amet justo magna. " +
                        "Sed aliquam nisl ut diam eleifend, id vehicula dolor vehicula. Praesent at ante ut sapien placerat dapibus in ut magna. " +
                        "Sed lacinia turpis vel neque efficitur mollis. Donec eget interdum ipsum. Vivamus euismod lorem sed consequat consectetur. " +
                        "Sed pretium nunc sit amet ante suscipit fringilla. Aliquam erat volutpat. Sed non arcu velit. Vivamus quis lectus eget nisi efficitur aliquam. " +
                        "Nullam sodales turpis id odio vulputate varius. Sed nec felis eu arcu convallis suscipit.",
                textAlign = TextAlign.Justify,
                fontSize = 15.sp
            )
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF449EEE)),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp)
                    .height(50.dp)
            ) {
                Text(text = "Donate!", fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun CampaignDetailCard() {
    Card {
        Column {
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Donation Target :", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(10.dp))
                LinearProgressIndicator(
                    progress = 65f / 100f,
                    color = Color(0xFF449EEE),
                    modifier = Modifier
                        .height(8.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0xFFD7DFE9))
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "65 boxes food of 100 boxes",
                    modifier = Modifier.padding(vertical = 2.dp),
                    fontSize = 15.sp
                )
            }
            Divider()
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Term and Condition : ")
                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.coin),
                        contentDescription = "Coin"
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = "Start From IDR 10.000")
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.pin),
                        contentDescription = "Pin"
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = "Jl. Soekarno Hatta & Nearest")
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.plate),
                        contentDescription = "Plate"
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = "Dry Food Only")
                }
            }
        }
    }
}