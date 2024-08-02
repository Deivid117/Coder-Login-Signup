package com.dwh.coder_login_signup.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dwh.coder_login_signup.login.navigation.loginRoute
import com.dwh.coder_login_signup.signup.navigation.signupRoute

@Composable
fun NavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.name
    ) {
        loginRoute(navigateToSignUp = { navController.navigate(AppScreen.Signup.name) })

        signupRoute(navigateBack = { navController.navigateUp() })
    }
}