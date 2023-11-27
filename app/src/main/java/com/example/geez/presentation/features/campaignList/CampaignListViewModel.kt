package com.example.geez.presentation.features.campaignList

import android.util.Log
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
class CampaignListViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {
    val token = preferencesManager.getData("token","")
    private val mutableState = MutableStateFlow<CampaignListUiState>(CampaignListUiState.Loading)
    val state =mutableState.asStateFlow()
    init {
        getAllCampaigns()
    }
    fun getAllCampaigns() {
        viewModelScope.launch {
            try {
                val res = ApiService.campaignService.getAllCampaigns("Bearer $token")
                mutableState.value = CampaignListUiState.Success(res)
            } catch (e: IOException) {
                mutableState.value = CampaignListUiState.Error
            } catch (e: HttpException) {
                mutableState.value = CampaignListUiState.Error
            }catch (e:Error){
                mutableState.value = CampaignListUiState.Error
            }
        }
    }
    fun getNearByCampaign(){
        mutableState.value = CampaignListUiState.Loading
        viewModelScope.launch {
            try {
                val res = ApiService.campaignService.getNearestCampaign("Bearer $token")
                mutableState.value = CampaignListUiState.Success(res)
            } catch (e: IOException) {
                mutableState.value = CampaignListUiState.Error
            } catch (e: HttpException) {
                mutableState.value = CampaignListUiState.Error
            }catch (e:Error){
                mutableState.value = CampaignListUiState.Error
            }
        }
    }
}