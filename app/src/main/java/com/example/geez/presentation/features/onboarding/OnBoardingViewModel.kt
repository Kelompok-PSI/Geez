package com.example.geez.presentation.features.onboarding

import androidx.lifecycle.ViewModel
import com.example.geez.data.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

//    private val mutableState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
//    val state =mutableState.asStateFlow()
//    fun login(email: String, password: String) {
//        viewModelScope.launch {
//            try {
//                if(
//                    preferencesManager.getData("token","")!==null
//                ){
//                    mutableState.value = ProfileUiState.LogedIn
//                }
//            }catch (e:Error){
//                mutableState.value = ProfileUiState.LogedOut
//            }
//        }
//    }
}