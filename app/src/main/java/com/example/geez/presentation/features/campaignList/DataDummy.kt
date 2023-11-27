package com.example.geez.presentation.features.campaignList

import com.example.geez.model.Campaign

object DataDummy {
    val dataDummy = listOf<Campaign>(
        Campaign(
            id = "1",
            name = "Palestine Campaign Food Donation by Indonesia Government",
            img="",
            reached = 200,
            target = 300,
            description = "This is a sample campaign description.",
            deadline = "2023-12-2"),
        Campaign(
            id = "2",
            name = "South Malang Food Donation by FAO UN",
            img = "",
            reached = 500,
            target = 1000,
            description = "South Malang Food Donation",
            deadline = "2023-12-31"),
        Campaign(
            id = "3",
            img = "",
            name = "West Malang Food Donation by FAO UN",
            reached = 500,
            target = 1000,
            description = "West Malang Food Donation by FAO UN",
            deadline = "2023-12-27"),
        Campaign(
            id = "4",
            name = "Food Donation For Zero Hunger SDGs",
            img = "",
            reached = 500,
            target = 1000,
            description = "Food Donation For Zero Hunger SDGs",
            deadline = "2023-11-31"),
    )
}