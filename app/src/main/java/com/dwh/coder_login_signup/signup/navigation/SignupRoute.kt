package com.dwh.coder_login_signup.signup.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dwh.coder_login_signup.core.navigation.AppScreen
import com.dwh.coder_login_signup.signup.presentation.SignupScreen
import com.dwh.coder_login_signup.signup.presentation.SignupViewModel

fun NavGraphBuilder.signupRoute(
    navigateBack: () -> Unit
) {
    composable(AppScreen.Signup.name) {

        val viewModel: SignupViewModel = viewModel { SignupViewModel() }
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        SignupScreen(
            viewModel = viewModel,
            state = state,
            navigateBack = navigateBack
        )
    }
}