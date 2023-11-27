package com.example.geez.presentation.features.registerReguler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geez.data.PreferencesManager
import com.example.geez.model.service.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    private val mutableState = MutableStateFlow<RegisterUiState>(RegisterUiState.Loading)
    val state =mutableState.asStateFlow()
    fun register(email: String,name:String, password: String ) {
        viewModelScope.launch {
            try {
                val res = ApiService.retrofitService.register(email,name,password )
                mutableState.value = RegisterUiState.Success(res.data)
            } catch (e: IOException) {
                mutableState.value = RegisterUiState.Error
            } catch (e: HttpException) {
                mutableState.value = RegisterUiState.Error
            }catch (e:Error){
                mutableState.value = RegisterUiState.Error
            }
        }
    }
}