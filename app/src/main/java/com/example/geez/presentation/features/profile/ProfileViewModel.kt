package com.example.geez.presentation.features.profile

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geez.data.PreferencesManager
import com.example.geez.model.service.AuthApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    private val mutableState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val state = mutableState.asStateFlow()
    fun logout() {
        viewModelScope.launch {
            try {
                preferencesManager.saveData("token", "")
                Log.i("logout", preferencesManager.getData("token", ""))
                mutableState.value = ProfileUiState.LogedOut
            } catch (e: Error) {
            }
        }
    }
}