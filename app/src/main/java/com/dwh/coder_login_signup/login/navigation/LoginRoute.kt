package com.dwh.coder_login_signup.login.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dwh.coder_login_signup.core.navigation.AppScreen
import com.dwh.coder_login_signup.login.presentation.LoginScreen
import com.dwh.coder_login_signup.login.presentation.LoginViewModel

fun NavGraphBuilder.loginRoute(
    navigateToSignUp: () -> Unit
) {
    composable(AppScreen.Login.name) {

        val viewModel: LoginViewModel = viewModel { LoginViewModel() }
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        LaunchedEffect(Unit) { viewModel.resetUiState() }

        LoginScreen(
            viewModel = viewModel,
            state = state,
            navigateToSignUp = navigateToSignUp
        )
    }
}