package com.example.geez.presentation.features.profile

import HistoryUiState
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geez.data.PreferencesManager
import com.example.geez.model.service.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    private val mutableState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val state = mutableState.asStateFlow()
    private val token = preferencesManager.getData("token", "")

    private val historyMutableState = MutableStateFlow<HistoryUiState>(HistoryUiState.Loading)
    val historyState = historyMutableState.asStateFlow()

    init {
        getAllHistory()
    }

    fun logout() {
        viewModelScope.launch {
            try {
                preferencesManager.saveData("token", "")
                Log.i("logout", preferencesManager.getData("token", ""))
                mutableState.value = ProfileUiState.LogedOut
            } catch (e: IOException) {

            }
        }
    }

    private fun getAllHistory() {
        viewModelScope.launch {
            try {
                val res = ApiService.historyService.getALlHistory("Bearer $token")
                historyMutableState.value = HistoryUiState.Success(res)
            } catch (e: Error) {
                historyMutableState.value = HistoryUiState.Error
            }
        }
    }
}
