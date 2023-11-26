package com.example.geez.presentation
import Onboarding
import SplashPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import com.example.geez.presentation.features.campaignDetails.CampaignDetail
import com.example.geez.presentation.features.campaignList.CampaignList
import com.example.geez.presentation.features.login.Login
import com.example.geez.presentation.features.registerBigParty.registerBigParty
import com.example.geez.presentation.navigation.Navigation
import com.example.geez.presentation.features.profile.Profile
import com.example.geez.presentation.ui.theme.GeezTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeezTheme {
                Navigation()
            }
        }
    }
}
