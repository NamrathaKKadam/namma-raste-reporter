package com.nammaraste.reporter.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToReport: () -> Unit,
    onNavigateToHistory: () -> Unit,
    onNavigateToStatus: () -> Unit,
    onLogout: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Namma-Raste Reporter") },
                actions = {
                    IconButton(onClick = onLogout) {
                        // Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
                        Text("Logout", fontSize = 12.sp)
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Welcome Back!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Help us keep our roads safe.",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            DashboardButton(
                title = "Report Issue",
                subtitle = "Potholes or Broken Streetlights",
                onClick = onNavigateToReport,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )

            DashboardButton(
                title = "Track Status",
                subtitle = "Check your report progress",
                onClick = onNavigateToStatus,
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )

            DashboardButton(
                title = "Previous Reports",
                subtitle = "View your history",
                onClick = onNavigateToHistory,
                containerColor = MaterialTheme.colorScheme.tertiaryContainer
            )
        }
    }
}

@Composable
fun DashboardButton(
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    containerColor: androidx.compose.ui.graphics.Color
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = subtitle, fontSize = 14.sp)
        }
    }
}
