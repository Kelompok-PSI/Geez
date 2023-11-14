package com.example.geez.presentation.features.campaignList

object DataDummy {
    val dataDummy = listOf<Campaign>(
        Campaign(
            id = "1",
            name = "Palestine Campaign Food Donation",
            reached = 200,
            target = 300,
            description = "This is a sample campaign description.",
            dueDate = "2023-12-2"),
        Campaign(
            id = "2",
            name = "South Malang Food Donation",
            reached = 500,
            target = 1000,
            description = "South Malang Food Donation",
            dueDate = "2023-12-31"),
        Campaign(
            id = "3",
            name = "Sidoarjo's Lampido Food Crisis ",
            reached = 500,
            target = 1000,
            description = "Sidoarjo's Lampido Food Crisis ",
            dueDate = "2023-12-27"),
        Campaign(
            id = "4",
            name = "Bandung Military Independence Formation",
            reached = 500,
            target = 1000,
            description = "This is a sample campaign description.",
            dueDate = "2023-11-31"),
    )
}