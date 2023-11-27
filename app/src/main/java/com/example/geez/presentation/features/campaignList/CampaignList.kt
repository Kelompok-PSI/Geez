package com.example.geez.presentation.features.campaignList

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.geez.R
import com.example.geez.model.Campaign
import com.example.geez.model.CampaignResponse
import com.example.geez.presentation.component.Loading
import com.example.geez.presentation.navigation.Screen


@Composable
fun CampaignList(
    navController: NavController,
    viewModel: CampaignListViewModel = hiltViewModel()
) {

    var localViewModel = viewModel.state.collectAsState().value

    var listCampaign: CampaignResponse = CampaignResponse()
    when (localViewModel) {
        is CampaignListUiState.Loading -> Loading()
        is CampaignListUiState.Success -> {
            listCampaign = localViewModel.campaigns
        }
        else -> {}
    }

    var sort by remember { mutableStateOf("newest") }

    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(
                    text = "Campaign",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 12.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Sort By: ", fontSize = 18.sp, color = Color(0xFF5E718D))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Newest",
                        fontSize = 15.sp,
                        color = if (sort == "newest") {
                            Color(0xFF449EEE)
                        } else {
                            Color(0xFFAFBACA)
                        },
                        modifier = Modifier
                            .border(
                                if (sort == "newest"){
                                    BorderStroke(1.dp, Color(0xFF449EEE))
                                }else{
                                    BorderStroke(1.dp, Color(0xFFAFBACA))
                                },
                                shape = RoundedCornerShape(25.dp)
                            )
                            .padding(vertical = 6.dp, horizontal = 15.dp)
                            .clickable {
                                if (sort == "nearby") {
                                    sort = "newest"
                                    viewModel.getAllCampaigns()
                                }
                            }
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Nearby",
                        color =
                        if (sort == "nearby") {
                            Color(0xFF449EEE)
                        } else {
                            Color(0xFFAFBACA)
                        },
                        fontSize = 15.sp,
                        modifier = Modifier
                            .border(
                                if (sort == "nearby"){
                                    BorderStroke(1.dp, Color(0xFF449EEE))
                                }else{
                                    BorderStroke(1.dp, Color(0xFFAFBACA))
                                },
                                shape = RoundedCornerShape(25.dp)
                            )
                            .padding(vertical = 6.dp, horizontal = 15.dp)
                            .clickable {
                                if (sort == "newest") {
                                    sort = "nearby"
                                    viewModel.getNearByCampaign()
                                }
                            }
                    )
                }
            }
            Spacer(modifier = Modifier.width(80.dp))
            IconButton(onClick = { navController.navigate(Screen.Profile.route) }) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn {
            items(listCampaign.data.size) { index ->
                CampaignCard(onClick = {
                    navController.navigate(Screen.CampaignDetail.withArgs(listCampaign.data[index].id))
                }, listCampaign.data[index])
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun CampaignCard(onClick: () -> Unit, campaign: Campaign) {
    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(8.dp))
        .background(color = Color.White)
        .fillMaxWidth()
        .fillMaxHeight(0.5f)
        .clickable { onClick() }) {
        Column() {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.image_1),
                    contentDescription = "dummypict",
                    contentScale = ContentScale.Fit
                )
//            AsyncImage(model = "", contentDescription = )
//            async image
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.padding(horizontal = 25.dp)
            ) {
                LinearProgressIndicator(
                    progress = campaign.reached.toFloat() / campaign.target.toFloat(),
                    color = Color(0xFF449EEE),
                    modifier = Modifier
                        .height(8.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0xFFD7DFE9))
                )
                Text(
                    text = "${campaign.reached} boxes food of ${campaign.target} boxes",
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    fontSize = 15.sp,
                    color = Color(0xFF5E718D)
                )
                Text(
                    text = "${campaign.name}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.clarity_date_line),
                        contentDescription = "date"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "until ${campaign.deadline.split("T")[0]}",
                        fontSize = 12.sp,
                        color = Color(0xFF5E718D)
                    )
                }
            }
        }
    }
}
