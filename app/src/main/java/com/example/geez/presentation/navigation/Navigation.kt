package com.example.geez.presentation.navigation

import Onboarding
import SplashPage
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
import com.example.geez.presentation.features.login.Login
import com.example.geez.presentation.features.profile.Profile
import com.example.geez.presentation.features.registerReguler.RegisterReguler

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route= Screen.Splash.route){
            SplashPage(navController=navController)
        }
        composable(route = Screen.OnBoarding.route){
            Onboarding(navController= navController)
        }
        composable(route = Screen.Login.route){
            Login(navController=navController)
        }
        composable(route = Screen.Register.route){
            RegisterReguler(navController = navController)
        }
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
            entry.arguments!!.getString("campaign_id")
                ?.let { CampaignDetail(id = it, navController) }
        }
        composable(
            route = Screen.FormDonation.route + "/{campaign_id}",
            arguments = listOf(
                navArgument("campaign_id"){
                    type = NavType.StringType
                    nullable = true
                }
            )
        ){entry ->
            entry.arguments!!.getString("campaign_id")
                ?.let { FormDonation(id = it, navController) }
        }
        composable(route = Screen.Profile.route){
            Profile(navController = navController)
        }
    }
}
