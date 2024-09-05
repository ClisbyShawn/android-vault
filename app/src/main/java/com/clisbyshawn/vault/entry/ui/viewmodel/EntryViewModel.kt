package com.clisbyshawn.vault.entry.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clisbyshawn.vault.entry.domain.usecase.WriteToFileUseCase
import com.clisbyshawn.vault.entry.ui.model.EntryScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class EntryViewModel @Inject constructor(
    private val writeToFile: WriteToFileUseCase,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _uiState = MutableStateFlow(EntryScreenUiState())
    val uiState: StateFlow<EntryScreenUiState> = _uiState.asStateFlow()

    fun onTextChanged(newValue: String) {
        _uiState.update { it.copy(userMessageForVault = newValue) }
    }

    fun onAddToVault() {
        viewModelScope.launch {
            writeToFile(
                directoryPath = context.filesDir.path,
                text = uiState.value.userMessageForVault.trim()
            )
            _uiState.update { it.copy(userMessageForVault = "") }
        }
    }
}