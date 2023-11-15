package com.example.geez.presentation.navigation

sealed class Screen(val route: String){
    object CampaignList : Screen("campaign_list")
    object CampaignDetail : Screen("campaign_detail")
    object FormDonation : Screen("form_donation")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
