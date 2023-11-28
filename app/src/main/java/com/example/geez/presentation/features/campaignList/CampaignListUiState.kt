package com.example.geez.presentation.features.campaignList

import com.example.geez.model.Campaign
import com.example.geez.model.CampaignResponse

sealed interface CampaignListUiState{
    data class Success(val campaigns: List<Campaign>): CampaignListUiState
    object Loading: CampaignListUiState
    object Error: CampaignListUiState
    object idle: CampaignListUiState
}