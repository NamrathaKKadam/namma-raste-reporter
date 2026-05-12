package com.nammaraste.reporter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nammaraste.reporter.data.repository.ReportRepository
import com.nammaraste.reporter.model.Report
import com.nammaraste.reporter.model.IssueType
import com.nammaraste.reporter.utils.TicketGenerator
import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class ReportViewModel(
    private val repository: ReportRepository,
    private val auth: FirebaseAuth
) : ViewModel() {

    private val _reports = MutableStateFlow<List<Report>>(emptyList())
    val reports: StateFlow<List<Report>> = _reports

    init {
        viewModelScope.launch {
            repository.getLocalReports().collect {
                _reports.value = it
            }
        }
    }

    fun submitReport(
        issueType: IssueType,
        imageUri: Uri,
        latitude: Double,
        longitude: Double,
        address: String
    ) {
        val user = auth.currentUser ?: return
        val report = Report(
            id = UUID.randomUUID().toString(),
            ticketId = TicketGenerator.generateTicketId(),
            issueType = issueType,
            latitude = latitude,
            longitude = longitude,
            address = address,
            userId = user.uid,
            userEmail = user.email ?: ""
        )

        viewModelScope.launch {
            try {
                repository.submitReport(report, imageUri)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
