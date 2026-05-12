package com.nammaraste.reporter.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nammaraste.reporter.ui.auth.LoginScreen
import com.nammaraste.reporter.ui.auth.RegisterScreen
import com.nammaraste.reporter.ui.home.HomeScreen
import com.nammaraste.reporter.ui.report.ReportScreen
import com.nammaraste.reporter.ui.history.HistoryScreen
import com.nammaraste.reporter.ui.status.StatusTrackerScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Report : Screen("report")
    object History : Screen("history")
    object Status : Screen("status")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { navController.navigate(Screen.Home.route) },
                onNavigateToRegister = { navController.navigate(Screen.Register.route) }
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate(Screen.Home.route) },
                onNavigateToLogin = { navController.popBackStack() }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToReport = { navController.navigate(Screen.Report.route) },
                onNavigateToHistory = { navController.navigate(Screen.History.route) },
                onNavigateToStatus = { navController.navigate(Screen.Status.route) },
                onLogout = { navController.navigate(Screen.Login.route) { popUpTo(0) } }
            )
        }
        composable(Screen.Report.route) {
            ReportScreen(
                onReportSubmitted = { navController.popBackStack() },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.History.route) {
            HistoryScreen(onBack = { navController.popBackStack() })
        }
        composable(Screen.Status.route) {
            StatusTrackerScreen(onBack = { navController.popBackStack() })
        }
    }
}
