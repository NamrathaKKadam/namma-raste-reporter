package com.nammaraste.reporter.data.repository

import com.nammaraste.reporter.data.local.ReportDao
import com.nammaraste.reporter.data.local.LocalReport
import com.nammaraste.reporter.model.Report
import com.nammaraste.reporter.model.IssueType
import com.nammaraste.reporter.model.ReportStatus
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import android.net.Uri
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class ReportRepository(
    private val reportDao: ReportDao,
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage
) {
    fun getLocalReports(): Flow<List<Report>> {
        return reportDao.getAllReports().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    suspend fun submitReport(report: Report, imageUri: Uri) {
        // 1. Upload to Storage
        val imageRef = storage.reference.child("reports/${report.ticketId}.jpg")
        imageRef.putFile(imageUri).await()
        val downloadUrl = imageRef.downloadUrl.await().toString()

        val finalReport = report.copy(imageUrl = downloadUrl)

        // 2. Save to Firestore
        firestore.collection("reports")
            .document(finalReport.id)
            .set(finalReport)
            .await()

        // 3. Cache locally
        reportDao.insertReport(finalReport.toLocal(isSynced = true))
    }

    private fun LocalReport.toDomain(): Report {
        return Report(
            id = id,
            ticketId = ticketId,
            issueType = IssueType.valueOf(issueType),
            imageUrl = imageUrl,
            latitude = latitude,
            longitude = longitude,
            address = address,
            userId = userId,
            status = ReportStatus.valueOf(status)
        )
    }

    private fun Report.toLocal(isSynced: Boolean): LocalReport {
        return LocalReport(
            id = id,
            ticketId = ticketId,
            issueType = issueType.name,
            imageUrl = imageUrl,
            latitude = latitude,
            longitude = longitude,
            address = address,
            timestamp = timestamp.toDate().time,
            userId = userId,
            status = status.name,
            isSynced = isSynced
        )
    }
}
