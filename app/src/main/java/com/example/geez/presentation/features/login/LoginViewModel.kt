package com.example.geez.presentation.features.login

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
class LoginViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    private val mutableState = MutableStateFlow<LoginUiState>(LoginUiState.Loading)
    val state =mutableState.asStateFlow()
    fun login(email: String, password: String) {
            viewModelScope.launch {
                try {
                    val res = ApiService.retrofitService.login(email, password)
                    preferencesManager.saveData("token",res.data.token)
                    mutableState.value = LoginUiState.Success(res.data)
                } catch (e: IOException) {
                    mutableState.value = LoginUiState.Error
                } catch (e: HttpException) {
                    mutableState.value = LoginUiState.Error
                }catch (e:Error){
                    mutableState.value = LoginUiState.Error
                }
            }
        }
    }