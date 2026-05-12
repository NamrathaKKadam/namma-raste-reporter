package com.nammaraste.reporter.model

import com.google.firebase.Timestamp

enum class IssueType {
    POTHOLE,
    BROKEN_STREETLIGHT
}

enum class ReportStatus {
    SUBMITTED,
    UNDER_REVIEW,
    REPAIR_IN_PROGRESS,
    RESOLVED
}

data class Report(
    val id: String = "",
    val ticketId: String = "",
    val issueType: IssueType = IssueType.POTHOLE,
    val imageUrl: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val address: String = "",
    val timestamp: Timestamp = Timestamp.now(),
    val userId: String = "",
    val userEmail: String = "",
    val status: ReportStatus = ReportStatus.SUBMITTED
)
