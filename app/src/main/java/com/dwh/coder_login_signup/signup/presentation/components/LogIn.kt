package com.dwh.coder_login_signup.signup.presentation.components

import androidx.compose.runtime.Composable
import com.dwh.coder_login_signup.core.presentation.components.CoderAuthActionRow

@Composable
fun LogIn(
    question: String,
    action: String,
    onClick: () -> Unit
) {
    CoderAuthActionRow(
        question = question,
        action = action,
        onClick = { onClick() }
    )
}