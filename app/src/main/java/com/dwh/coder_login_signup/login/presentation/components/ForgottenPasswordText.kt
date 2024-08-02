package com.dwh.coder_login_signup.login.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.dwh.coder_login_signup.R

@Composable
fun ForgottenPasswordText(onClick: () -> Unit) {
    Text(
        modifier = Modifier.clickable { onClick() },
        text = stringResource(id = R.string.login_forgotten_password),
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.primary,
    )
}