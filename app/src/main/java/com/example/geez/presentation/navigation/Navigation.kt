package com.example.geez.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.geez.presentation.features.campaignDetails.CampaignDetail
import com.example.geez.presentation.features.campaignList.CampaignList
import com.example.geez.presentation.features.formDonation.FormDonation
import com.example.geez.presentation.features.profile.Profile

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CampaignList.route){
        composable(route = Screen.CampaignList.route){
            CampaignList(navController = navController)
        }
        composable(
            route = Screen.CampaignDetail.route + "/{campaign_id}",
            arguments = listOf(
                navArgument("campaign_id"){
                    type = NavType.StringType
                    nullable = true
                }
            )
        ){entry ->
            CampaignDetail(id = entry.arguments?.getString("campaign_id"), navController)
        }
        composable(route = Screen.FormDonation.route){
            FormDonation(navController = navController)
        }
        composable(route = Screen.Profile.route){
            Profile()
        }
    }
}
