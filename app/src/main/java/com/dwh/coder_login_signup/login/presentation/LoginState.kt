package com.dwh.coder_login_signup.login.presentation

import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.ui.UiText

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: UiText? = null,
    val passwordError: UiText? = null,
    val isSnackBarVisible: Boolean = false,
    val snackBarMessage: UiText = UiText.StringResource(R.string.login_snackbar_message1)
)
