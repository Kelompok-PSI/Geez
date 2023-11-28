import com.example.geez.presentation.features.profile.ProfileUiState

sealed interface HistoryUiState{
    data class Success(val data: HistoryResp): HistoryUiState
    object Loading: HistoryUiState
    object Error: HistoryUiState
}