package com.example.geez.presentation.features.registerReguler

import com.example.geez.model.Register
import com.example.geez.model.RegisterResponse
import com.example.geez.presentation.features.profile.ProfileUiState

sealed interface RegisterUiState{
    data class Success(val register: Register):RegisterUiState
    object Loading: RegisterUiState
    object Error: RegisterUiState
    object idle: RegisterUiState
}