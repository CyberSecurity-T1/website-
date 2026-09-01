package com.cyberleveling.labs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberleveling.domain.usecase.ValidateLabTaskUseCase
import com.cyberleveling.domain.usecase.XpSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LabUiState(
    val terminalOutput: List<String> = listOf(
        "user@lab:~$ ls",
        "bin  etc  home  lab-data",
        "user@lab:~$"
    ),
    val isCompleted: Boolean = false,
    val feedback: String = "Awaiting command input..."
)

@HiltViewModel
class LabViewModel @Inject constructor(
    private val validateLabTaskUseCase: ValidateLabTaskUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LabUiState())
    val uiState: StateFlow<LabUiState> = _uiState.asStateFlow()

    private val _xpRewardEvent = MutableSharedFlow<XpSource>()
    val xpRewardEvent = _xpRewardEvent.asSharedFlow()

    fun submitCommand(command: String, expectedCommand: String = "ls") {
        val result = validateLabTaskUseCase.execute(command, expectedCommand)

        val output = buildList {
            addAll(_uiState.value.terminalOutput)
            add("root@lab:~$ $command")
            add(if (result.isValid) "SUCCESS: ${result.message}" else "ERROR: ${result.message}")
        }

        _uiState.update {
            it.copy(
                terminalOutput = output,
                isCompleted = result.isValid,
                feedback = result.message
            )
        }

        if (result.isValid) {
            viewModelScope.launch {
                _xpRewardEvent.emit(XpSource.LAB)
            }
        }
    }
}
