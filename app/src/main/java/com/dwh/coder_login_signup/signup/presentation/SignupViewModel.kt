package com.dwh.coder_login_signup.signup.presentation

import androidx.lifecycle.ViewModel
import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.ui.UiText
import com.dwh.coder_login_signup.core.presentation.utils.regex.RegexFunctions.containsLetter
import com.dwh.coder_login_signup.core.presentation.utils.regex.RegexFunctions.containsNumber
import com.dwh.coder_login_signup.core.presentation.utils.regex.RegexFunctions.containsSpecialCharacter
import com.dwh.coder_login_signup.core.presentation.utils.regex.RegexFunctions.isEmail
import com.dwh.coder_login_signup.core.presentation.utils.regex.RegexFunctions.numericRegex
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SignupViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<SignupState> = MutableStateFlow(SignupState())
    val uiState: StateFlow<SignupState> get() = _uiState

    private fun showSnackBar(snackBarMessage: UiText) {
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

    private fun formattedPhoneNumber(value: String) : String {
        val stripped = numericRegex().replace(value, "")
        return if (stripped.length >= 11) stripped.substring(0..10) else stripped
    }

    fun onPhoneNumberChange(phoneNumber: String) {
        _uiState.update { currentState ->
            currentState.copy(phoneNumber = formattedPhoneNumber(phoneNumber))
        }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { currentState ->
            currentState.copy(password = password)
        }
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        _uiState.update { currentState ->
            currentState.copy(confirmPassword = confirmPassword)
        }
    }

    private fun validateEmail(email: String): UiText? {
        return when {
            email.isEmpty() -> UiText.StringResource(R.string.signup_email_error1)
            !email.isEmail() -> UiText.StringResource(R.string.signup_email_error2)
            else -> null
        }
    }

    private fun validatePhoneNumber(phoneNumber: String): UiText? {
        return when {
            phoneNumber.isEmpty() -> UiText.StringResource(R.string.signup_phone_number_error1)
            phoneNumber.length < 11 -> UiText.StringResource(R.string.signup_phone_number_error2)
            else -> null
        }
    }

    private fun validatePassword(password: String): UiText? {
        return when {
            password.isEmpty() -> UiText.StringResource(R.string.signup_password_error1)
            !password.containsLetter() -> UiText.StringResource(R.string.signup_password_error2)
            !password.containsNumber() -> UiText.StringResource(R.string.signup_password_error3)
            !password.containsSpecialCharacter() -> UiText.StringResource(R.string.signup_password_error4)
            password.length < 10 -> UiText.StringResource(R.string.signup_password_error5)
            else -> null
        }
    }

    private fun validateConfirmPassword(confirmPassword: String): UiText? {
        return when {
            confirmPassword != uiState.value.password -> UiText.StringResource(R.string.signup_confirm_password_error1)
            else -> null
        }
    }

    private fun validateAndSetErrors(state: SignupState) {
        val emailError = validateEmail(state.email)
        val phoneNumberError = validatePhoneNumber(state.phoneNumber)
        val passwordError = validatePassword(state.password)
        val confirmPasswordError = validateConfirmPassword(state.confirmPassword)

        _uiState.update { currentState ->
            currentState.copy(
                emailError = emailError,
                phoneNumberError = phoneNumberError,
                passwordError = passwordError,
                confirmPasswordError = confirmPasswordError
            )
        }
    }

    fun signUp() {
        validateAndSetErrors(uiState.value)
        showSnackBar(UiText.StringResource(R.string.signup_snackbar_message))
    }
}