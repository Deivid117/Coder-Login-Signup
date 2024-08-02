package com.dwh.coder_login_signup.signup.presentation.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.components.CoderTextField
import com.dwh.coder_login_signup.core.presentation.ui.UiText
import com.dwh.coder_login_signup.core.presentation.utils.visual_transformation.PhoneNumberVisualTransformation

@Composable
fun SignupForm(
    email: String,
    phoneNumber: String,
    password: String,
    confirmPassword: String,
    onEmailChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    emailError: UiText?,
    phoneNumberError: UiText?,
    passwordError: UiText?,
    confirmPasswordError: UiText?
) {
    val focusManager = LocalFocusManager.current

    CoderTextField(
        value = email,
        onValueChange = { onEmailChange(it) },
        label = stringResource(id = R.string.signup_email_textfield_label),
        placeholder = stringResource(id = R.string.signup_email_textfield_placeholder),
        errorValue = emailError,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email icon") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) })
    )

    CoderTextField(
        value = phoneNumber,
        onValueChange = { onPhoneNumberChange(it) },
        label = stringResource(id = R.string.signup_phone_number_textfield_label),
        placeholder = stringResource(id = R.string.signup_phone_number_textfield_placeholder),
        errorValue = phoneNumberError,
        leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = "phone icon") },
        visualTransformation = PhoneNumberVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) })
    )

    CoderTextField(
        value = password,
        onValueChange = { onPasswordChange(it) },
        label = stringResource(id = R.string.signup_password_textfield_label),
        placeholder = stringResource(id = R.string.signup_password_textfield_placeholder),
        isPasswordTextField = true,
        errorValue = passwordError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) })
    )

    CoderTextField(
        value = confirmPassword,
        onValueChange = { onConfirmPasswordChange(it) },
        label = stringResource(id = R.string.signup_confirm_password_textfield_label),
        placeholder = stringResource(id = R.string.signup_confirm_password_textfield_placeholder),
        isPasswordTextField = true,
        errorValue = confirmPasswordError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
    )
}