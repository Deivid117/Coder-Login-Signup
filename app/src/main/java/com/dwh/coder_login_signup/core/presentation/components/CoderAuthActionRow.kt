package com.dwh.coder_login_signup.core.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CoderAuthActionRow(
    question: String,
    action: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = question,
            style = MaterialTheme.typography.labelMedium
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            modifier = Modifier.clickable { onClick() },
            text = action,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium
        )
    }
}