package com.dwh.coder_login_signup.signup.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.components.CoderButton
import com.dwh.coder_login_signup.core.presentation.components.CoderScaffold
import com.dwh.coder_login_signup.core.presentation.components.CoderHeaderText
import com.dwh.coder_login_signup.core.presentation.components.CoderWavyShapeHeader
import com.dwh.coder_login_signup.signup.presentation.components.LogIn
import com.dwh.coder_login_signup.signup.presentation.components.SignupForm

@Composable
fun SignupScreen(
    viewModel: SignupViewModel,
    state: SignupState,
    navigateBack: () -> Unit
) {
    CoderScaffold(
        snackBarMessage = state.snackBarMessage.asString(),
        isSnackBarVisible = state.isSnackBarVisible,
        onDismissSnackBar = { viewModel.hideSnackBar() }
    ) {
        CoderWavyShapeHeader()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CoderHeaderText(title = stringResource(id = R.string.signup))

            Spacer(modifier = Modifier.height(5.dp))

            SignupForm(
                email = state.email,
                phoneNumber = state.phoneNumber,
                password = state.password,
                confirmPassword = state.confirmPassword,
                onEmailChange = { viewModel.onEmailChange(it) },
                onPhoneNumberChange = { viewModel.onPhoneNumberChange(it) },
                onPasswordChange = { viewModel.onPasswordChange(it) },
                onConfirmPasswordChange = { viewModel.onConfirmPasswordChange(it) },
                emailError = state.emailError,
                phoneNumberError = state.phoneNumberError,
                passwordError = state.passwordError,
                confirmPasswordError = state.confirmPasswordError
            )

            Spacer(modifier = Modifier.height(5.dp))

            CoderButton(
                modifier = Modifier.fillMaxWidth(),
                buttonName = stringResource(id = R.string.signup_button_name)
            ) { viewModel.signUp() }

            Spacer(modifier = Modifier.height(5.dp))

            LogIn(
                question = stringResource(id = R.string.signup_have_account),
                action = stringResource(id = R.string.signup_login)
            ) { navigateBack() }
        }
    }
}