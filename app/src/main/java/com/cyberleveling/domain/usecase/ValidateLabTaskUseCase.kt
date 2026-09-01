package com.cyberleveling.domain.usecase

import javax.inject.Inject

data class LabValidationResult(
    val isValid: Boolean,
    val message: String,
    val xpEarned: Int = 0
)

class ValidateLabTaskUseCase @Inject constructor() {

    fun execute(command: String, expectedCommand: String): LabValidationResult {
        val normalizedInput = command.trim().lowercase()
        val normalizedExpected = expectedCommand.trim().lowercase()

        return if (normalizedInput == normalizedExpected) {
            LabValidationResult(
                isValid = true,
                message = "Lab objective complete. Safe verification passed.",
                xpEarned = 75
            )
        } else {
            LabValidationResult(
                isValid = false,
                message = "Command mismatch. Try the guided command for this safe lab.",
                xpEarned = 0
            )
        }
    }
}
