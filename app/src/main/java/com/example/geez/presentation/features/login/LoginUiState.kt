package com.example.geez.presentation.features.login

import com.example.geez.model.User

sealed interface LoginUiState{
    data class Success(val user:User):LoginUiState
    object Error: LoginUiState
    object idle: LoginUiState
    object Loading: LoginUiState
}

