package com.clisbyshawn.vault.vault.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clisbyshawn.vault.common.domain.usecase.DecryptByteArrayUseCase
import com.clisbyshawn.vault.vault.domain.usecase.ReadFromFileUseCase
import com.clisbyshawn.vault.vault.ui.model.VaultUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class TheVaultViewModel @Inject constructor(
    private val readFile: ReadFromFileUseCase,
    private val decryptByteArrayUseCase: DecryptByteArrayUseCase,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _uiState = MutableStateFlow(VaultUiState())
    val uiState: StateFlow<VaultUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    encryptedText = readFile(directoryPath = context.filesDir.path)?.decodeToString()
                        ?: ""
                )
            }
        }
    }

    fun onDecodeText() {
        viewModelScope.launch {
            val cipherByteArray = readFile(directoryPath = context.filesDir.path)
            cipherByteArray?.let {
                val decryptedByteArray = decryptByteArrayUseCase(cipherByteArray)
                val plainText = decryptedByteArray?.decodeToString()
                plainText?.let { text -> _uiState.update { it.copy(decryptedText = text) } }
            }
        }
    }
}