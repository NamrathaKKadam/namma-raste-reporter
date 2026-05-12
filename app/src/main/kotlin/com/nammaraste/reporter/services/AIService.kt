package com.nammaraste.reporter.services

import com.nammaraste.reporter.model.IssueType
import kotlin.random.Random

/**
 * Placeholder for AI-based pothole severity detection.
 * In a production app, this would call a TFLite model or a specialized API.
 */
object AIService {

    data class SeverityResult(
        val severity: String, // Low, Medium, High
        val confidence: Float
    )

    fun detectPotholeSeverity(imagePath: String): SeverityResult {

        val confidenceValue = Random.nextDouble(0.80, 0.99)

        return SeverityResult(
            severity = listOf("Low", "Medium", "High").random(),
            confidence = confidenceValue.toFloat()
        )
    }
}