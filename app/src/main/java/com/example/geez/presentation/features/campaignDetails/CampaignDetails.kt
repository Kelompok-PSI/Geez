package com.example.geez.presentation.features.campaignDetails

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.geez.R
import com.example.geez.model.Campaign
import com.example.geez.model.CampaignDetail
import com.example.geez.model.CampaignDetailResp
import com.example.geez.model.CampaignResponse
import com.example.geez.presentation.component.Loading
import com.example.geez.presentation.navigation.Screen

@Composable
fun CampaignDetail(
    id: String,
    navController: NavController,
    viewModel: CampaignDetailViewModel = hiltViewModel()
) {
//    var localViewModel = viewModel.state.collectAsState().value
    var localViewModel = viewModel.state.collectAsState().value
    LaunchedEffect(localViewModel){
        viewModel.getCampaignDetail(id)
    }
    var campaignDetail: CampaignDetail = CampaignDetail(
        id = "",
        name = "",
        img = "",
        reached = 0,
        target = 0,
        location = "",
        deadline = "",
        startFromIdr = "",
        description = "",
        specificFood = ""
    )
    when (localViewModel) {
        is CampaignDetailUiState.Loading -> Loading()
        is CampaignDetailUiState.Success -> {
            campaignDetail = localViewModel.campaign.data
            Log.i("Campaign-Detail",campaignDetail.toString())
        }
        else -> {}
    }
    LazyColumn(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 25.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.back),
                    contentDescription = "Back",
                    Modifier.clickable { navController.popBackStack() })
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Campaign Details",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(15.dp))
            Image(
                painter = painterResource(id = R.drawable.image_1),
                contentDescription = "dummypict",
                contentScale = ContentScale.Fit,
                modifier = Modifier.clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
        item {
            CampaignDetailCard(campaignDetail)
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
                text = campaignDetail.description,
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
                text = campaignDetail.specificFood,
                textAlign = TextAlign.Justify,
                fontSize = 15.sp
            )
            Button(
                onClick = { navController.navigate(Screen.FormDonation.withArgs(id)) },
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
fun CampaignDetailCard(campaignDetail: CampaignDetail) {
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
                    progress = campaignDetail.reached.toFloat() / campaignDetail.target.toFloat(),
                    color = Color(0xFF449EEE),
                    modifier = Modifier
                        .height(8.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0xFFD7DFE9))
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "${campaignDetail.reached} boxes food of ${campaignDetail.target} boxes",
                    modifier = Modifier.padding(vertical = 2.dp),
                    fontSize = 15.sp,
                    color = Color(0xFF5E718D)
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
                    Text(text = "Start From IDR ${campaignDetail.startFromIdr}")
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.pin),
                        contentDescription = "Pin"
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = campaignDetail.location)
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.plate),
                        contentDescription = "Plate"
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = campaignDetail.rules?: "ini pasti ada")
                }
            }
        }
    }
}