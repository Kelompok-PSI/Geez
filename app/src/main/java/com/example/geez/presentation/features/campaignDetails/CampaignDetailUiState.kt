package com.example.geez.presentation.features.campaignDetails

import com.example.geez.model.Campaign
import com.example.geez.model.CampaignDetailResp


sealed interface CampaignDetailUiState{
    data class Success(val campaign: CampaignDetailResp): CampaignDetailUiState
    object Loading: CampaignDetailUiState
    object Error: CampaignDetailUiState
    object idle: CampaignDetailUiState
}