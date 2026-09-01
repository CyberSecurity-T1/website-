package com.cyberleveling.data.remote.api

import retrofit2.http.Body
import retrofit2.http.POST

data class AiPromptRequest(
    val message: String,
    val context: String? = null
)

data class AiPromptResponse(
    val reply: String,
    val success: Boolean = true
)

interface AIApiService {
    @POST("/api/ai/hint")
    suspend fun sendMessage(@Body request: AiPromptRequest): AiPromptResponse
}
