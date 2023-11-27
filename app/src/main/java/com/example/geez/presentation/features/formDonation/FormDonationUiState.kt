package com.example.geez.presentation.features.formDonation

sealed interface FormDonationUiState{
    object Success: FormDonationUiState
    object Loading: FormDonationUiState
    object Error: FormDonationUiState
    object idle: FormDonationUiState
}