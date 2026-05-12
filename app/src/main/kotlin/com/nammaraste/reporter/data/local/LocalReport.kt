package com.nammaraste.reporter.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nammaraste.reporter.model.IssueType
import com.nammaraste.reporter.model.ReportStatus

@Entity(tableName = "reports")
data class LocalReport(
    @PrimaryKey val id: String,
    val ticketId: String,
    val issueType: String,
    val imageUrl: String,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val timestamp: Long,
    val userId: String,
    val status: String,
    val isSynced: Boolean = false
)
