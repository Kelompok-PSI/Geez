package com.example.geez.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.geez.presentation.features.campaignDetails.CampaignDetail
import com.example.geez.presentation.features.campaignList.CampaignList
import com.example.geez.presentation.navigation.Navigation
import com.example.geez.presentation.features.profile.Profile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
//            CampaignList()
//            CampaignDetail()
        }
    }
}