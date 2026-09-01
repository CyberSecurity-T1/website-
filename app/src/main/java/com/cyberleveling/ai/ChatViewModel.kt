package com.cyberleveling.ai

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberleveling.data.remote.api.AIApiService
import com.cyberleveling.data.remote.api.AiPromptRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ChatMessage(
    val id: String,
    val text: String,
    val sender: Sender,
    val isLoading: Boolean = false
) {
    enum class Sender {
        USER,
        BOT
    }
}

data class ChatUiState(
    val messages: List<ChatMessage> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val aiApiService: AIApiService
) : ViewModel() {

    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    fun sendMessage(message: String) {
        if (message.isBlank()) return

        val userMessage = ChatMessage(
            id = System.currentTimeMillis().toString(),
            text = message,
            sender = ChatMessage.Sender.USER
        )

        val loadingMessage = ChatMessage(
            id = "loading-${System.currentTimeMillis()}",
            text = "Analyzing...",
            sender = ChatMessage.Sender.BOT,
            isLoading = true
        )

        _uiState.update {
            it.copy(
                messages = it.messages + userMessage + loadingMessage,
                isLoading = true,
                errorMessage = null
            )
        }

        viewModelScope.launch {
            try {
                val response = aiApiService.sendMessage(
                    AiPromptRequest(
                        message = message,
                        context = "Cybersecurity educational assistant for safe learning"
                    )
                )

                val botReply = ChatMessage(
                    id = "bot-${System.currentTimeMillis()}",
                    text = response.reply,
                    sender = ChatMessage.Sender.BOT
                )

                _uiState.update {
                    it.copy(
                        messages = it.messages.filterNot { msg -> msg.isLoading } + botReply,
                        isLoading = false,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        messages = it.messages.filterNot { msg -> msg.isLoading },
                        isLoading = false,
                        errorMessage = "Unable to reach the AI tutor right now. Please try again."
                    )
                }
            }
        }
    }
}
