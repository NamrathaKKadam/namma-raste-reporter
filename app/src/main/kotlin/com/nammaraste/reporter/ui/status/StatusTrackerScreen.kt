package com.nammaraste.reporter.ui.status

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nammaraste.reporter.model.Report
import com.nammaraste.reporter.model.ReportStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatusTrackerScreen(onBack: () -> Unit) {
    var ticketIdInput by remember { mutableStateOf("") }
    var searchedReport by remember { mutableStateOf<Report?>(null) }
    var isSearching by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Track Status") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Text("<")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = ticketIdInput,
                onValueChange = { ticketIdInput = it },
                label = { Text("Enter Ticket ID (NR-YYYY-XXXX)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { 
                    isSearching = true
                    // Simulate Search
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Search")
            }

            Spacer(modifier = Modifier.height(32.dp))

            if (searchedReport != null) {
                StatusDetail(searchedReport!!)
            } else if (!isSearching) {
                Text(
                    text = "Enter a valid Ticket ID to see the current status of the repair work.",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun StatusDetail(report: Report) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(text = "Ticket ID: ${report.ticketId}", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Issue: ${report.issueType.name}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Status: ${report.status.name}", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Progress tracker visual
            ReportProgress(report.status)
        }
    }
}

@Composable
fun ReportProgress(currentStatus: ReportStatus) {
    val statuses = ReportStatus.values()
    val currentIndex = currentStatus.ordinal

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        statuses.forEachIndexed { index, status ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = index <= currentIndex, onClick = null)
                Text(
                    text = status.name.replace("_", " "),
                    color = if (index <= currentIndex) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
