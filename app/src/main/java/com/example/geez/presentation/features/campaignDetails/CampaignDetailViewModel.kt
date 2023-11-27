package com.example.geez.presentation.features.campaignDetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geez.data.PreferencesManager
import com.example.geez.model.service.ApiService
import com.example.geez.presentation.features.campaignList.CampaignListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
@HiltViewModel
class CampaignDetailViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
):ViewModel(){
    val token = preferencesManager.getData("token","")
    private val mutableState = MutableStateFlow<CampaignDetailUiState>(CampaignDetailUiState.Loading)
    val state =mutableState.asStateFlow()
    fun getCampaignDetail(campaignId:String) {
        viewModelScope.launch {
            try {
                Log.i("campaign-detail",campaignId)
                val res = ApiService.campaignService.getDetailCampaign("Bearer $token",campaignId)
                mutableState.value = CampaignDetailUiState.Success(res)
            } catch (e: IOException) {
                mutableState.value = CampaignDetailUiState.Error
            } catch (e: HttpException) {
                mutableState.value = CampaignDetailUiState.Error
            }catch (e:Error){
                mutableState.value = CampaignDetailUiState.Error
            }
        }
    }
}