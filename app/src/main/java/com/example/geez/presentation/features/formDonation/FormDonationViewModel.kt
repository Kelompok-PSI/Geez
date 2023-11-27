package com.example.geez.presentation.features.formDonation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geez.data.PreferencesManager
import com.example.geez.lib.convertDateFormat
import com.example.geez.model.Donation
import com.example.geez.model.service.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class FormDonationViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {
    val token = preferencesManager.getData("token", "")

    val mutableState = MutableStateFlow<FormDonationUiState>(FormDonationUiState.idle)
    val state = mutableState.asStateFlow()
    fun donate(id:String,foodName:String,quantity:String,expDate:String,location:String) {
        val dateConverted = convertDateFormat(expDate)
        val donationData = Donation(
            campaignId = id.toInt(),
            food = foodName,
            quantity = 5,
            expiredDate = expDate,
            pickupLocation = location
        )
        viewModelScope.launch {
            try {
                var newFormatDate = convertDateFormat(expDate)
                val res = ApiService.campaignService.donate("Bearer $token",donationData)
                mutableState.value = FormDonationUiState.Success
            } catch (e: IOException) {
                Log.i("Ioexc", e.toString())
                mutableState.value = FormDonationUiState.Error
            } catch (e: HttpException) {
                Log.i("https", e.stackTraceToString())
                mutableState.value = FormDonationUiState.Error
            } catch (e: Error) {
                Log.i("general", e.toString())
                mutableState.value = FormDonationUiState.Error
            }
        }
    }
}
