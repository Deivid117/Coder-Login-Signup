package com.dwh.coder_login_signup.signup.presentation

import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.ui.UiText

data class SignupState(
    val email: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val emailError: UiText? = null,
    val phoneNumberError: UiText? = null,
    val passwordError: UiText? = null,
    val confirmPasswordError: UiText? = null,
    val isSnackBarVisible: Boolean = false,
    val snackBarMessage: UiText = UiText.StringResource(R.string.login_snackbar_message1)
)
