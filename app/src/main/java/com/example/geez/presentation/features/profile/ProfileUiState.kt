package com.example.geez.presentation.features.profile

import com.example.geez.model.User
import com.example.geez.presentation.features.login.LoginUiState

sealed interface ProfileUiState{
    object Loading:ProfileUiState
    object LogedOut: ProfileUiState
    object idle: ProfileUiState
}