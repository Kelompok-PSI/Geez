package com.example.geez.model


data class Campaign(
    val id: String,
    val name: String,
    val reached: Int,
    val target: Int,
    val description: String,
    val dueDate: String
)
