package com.dwh.coder_login_signup.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.components.CoderButton
import com.dwh.coder_login_signup.core.presentation.components.CoderScaffold
import com.dwh.coder_login_signup.core.presentation.ui.UiText
import com.dwh.coder_login_signup.login.presentation.components.ForgottenPasswordText
import com.dwh.coder_login_signup.login.presentation.components.LoginForm
import com.dwh.coder_login_signup.core.presentation.components.CoderHeaderText
import com.dwh.coder_login_signup.login.presentation.components.RememberMeCheckBox
import com.dwh.coder_login_signup.login.presentation.components.SignUp
import com.dwh.coder_login_signup.core.presentation.components.CoderWavyShapeHeader

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    state: LoginState,
    navigateToSignUp: () -> Unit,
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
            CoderHeaderText(title = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(5.dp))

            LoginForm(
                email = state.email,
                emailError = state.emailError,
                password = state.password,
                passwordError = state.passwordError,
                onEmailChange = { viewModel.onEmailChange(it) },
                onPasswordChange = { viewModel.onPasswordChange(it) }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RememberMeCheckBox(modifier = Modifier.weight(1f)) { viewModel.showSnackBar(it) }

                ForgottenPasswordText { viewModel.showSnackBar(UiText.StringResource(R.string.login_snackbar_message4)) }
            }

            Spacer(modifier = Modifier.height(5.dp))

            CoderButton(
                modifier = Modifier.fillMaxWidth(),
                buttonName = stringResource(id = R.string.login_button_name)
            ) { viewModel.logIn() }

            Spacer(modifier = Modifier.height(5.dp))

            SignUp(
                question = stringResource(id = R.string.login_dont_have_account),
                action = stringResource(id = R.string.login_sign_up)
            ) { navigateToSignUp() }
        }
    }
}