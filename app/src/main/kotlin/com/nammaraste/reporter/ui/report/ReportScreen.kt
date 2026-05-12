package com.nammaraste.reporter.ui.report

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nammaraste.reporter.model.IssueType
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(
    onReportSubmitted: () -> Unit,
    onBack: () -> Unit
) {
    var capturedImageUri by remember { mutableStateOf<String?>(null) }
    var selectedIssueType by remember { mutableStateOf(IssueType.POTHOLE) }
    var isSubmitting by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("New Report") },
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
            // Camera Preview Placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                if (capturedImageUri == null) {
                    Button(onClick = { capturedImageUri = "dummy_uri" }) {
                        Text("Capture Image")
                    }
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Image Captured ✅")
                        TextButton(onClick = { capturedImageUri = null }) {
                            Text("Retake")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Select Issue Type:", fontSize = 16.sp)
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FilterChip(
                    selected = selectedIssueType == IssueType.POTHOLE,
                    onClick = { selectedIssueType = IssueType.POTHOLE },
                    label = { Text("Pothole") }
                )
                FilterChip(
                    selected = selectedIssueType == IssueType.BROKEN_STREETLIGHT,
                    onClick = { selectedIssueType = IssueType.BROKEN_STREETLIGHT },
                    label = { Text("Broken Streetlight") }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { 
                    isSubmitting = true
                    // Simulate Submission
                    onReportSubmitted() 
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = capturedImageUri != null && !isSubmitting
            ) {
                if (isSubmitting) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Submit Report")
                }
            }
        }
    }
}
