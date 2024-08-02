package com.dwh.coder_login_signup.login.presentation.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
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

@Composable
fun LoginForm(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    emailError: UiText?,
    passwordError: UiText?
) {
    val focusManager = LocalFocusManager.current

    CoderTextField(
        value = email,
        onValueChange = { onEmailChange(it) },
        label = stringResource(id = R.string.login_email_textfield_label),
        placeholder = stringResource(id = R.string.login_email_textfield_placeholder),
        errorValue = emailError,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email icon") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) })
    )

    CoderTextField(
        value = password,
        onValueChange = { onPasswordChange(it) },
        label = stringResource(id = R.string.login_password_textfield_label),
        placeholder = stringResource(id = R.string.login_password_textfield_placeholder),
        isPasswordTextField = true,
        errorValue = passwordError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
    )
}