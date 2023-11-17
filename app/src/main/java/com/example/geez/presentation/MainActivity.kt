package com.example.geez.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.geez.presentation.features.campaignDetails.CampaignDetail
import com.example.geez.presentation.features.campaignList.CampaignList
import com.example.geez.presentation.features.login.Login
import com.example.geez.presentation.features.registerBigParty.registerBigParty
import com.example.geez.presentation.navigation.Navigation
import com.example.geez.presentation.features.registerReguler.registerReguler
import com.example.geez.presentation.features.registerReguler.registerReguler

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            registerBigParty()
//            registerReguler()
            Login()
//            Navigation()
//            CampaignList()
//            CampaignDetail()
        }
    }
}