package com.dwh.coder_login_signup.login.presentation

import androidx.lifecycle.ViewModel
import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.ui.UiText
import com.dwh.coder_login_signup.core.presentation.utils.regex.RegexFunctions.isEmail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> get() = _uiState.asStateFlow()

    fun showSnackBar(snackBarMessage: UiText) {
        _uiState.update { currentState ->
            currentState.copy(
                isSnackBarVisible = true,
                snackBarMessage = snackBarMessage
            )
        }
    }

    fun hideSnackBar() {
        _uiState.update { currentState ->
            currentState.copy(
                isSnackBarVisible = false,
                snackBarMessage = UiText.StringValue("")
            )
        }
    }

    fun onEmailChange(email: String) {
        _uiState.update { currentState ->
            currentState.copy(email = email)
        }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { currentState ->
            currentState.copy(password = password)
        }
    }

    private fun validateEmail(email: String): UiText? {
        return when {
            email.isEmpty() -> UiText.StringResource(R.string.login_email_error1)
            !email.isEmail() -> UiText.StringResource(R.string.login_email_error2)
            else -> null
        }
    }

    private fun validatePassword(password: String): UiText? {
        return when {
            password.isEmpty() -> UiText.StringResource(R.string.login_password_error1)
            password != "abcABC#123" -> UiText.StringResource(R.string.login_password_error2)
            else -> null
        }
    }

    private fun validateAndSetErrors(state: LoginState) {
        val emailError = validateEmail(state.email)
        val passwordError = validatePassword(state.password)

        _uiState.update { currentState ->
            currentState.copy(
                emailError = emailError,
                passwordError = passwordError
            )
        }
    }

    fun logIn() {
        validateAndSetErrors(uiState.value)
        showSnackBar(UiText.StringResource(R.string.login_snackbar_message1))
    }

    fun resetUiState() {
        _uiState.value = LoginState()
    }
}