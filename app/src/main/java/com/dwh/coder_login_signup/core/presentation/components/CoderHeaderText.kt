package com.dwh.coder_login_signup.core.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dwh.coder_login_signup.core.presentation.utils.modifier.bottomBorder

@Composable
fun CoderHeaderText(title: String) {
    Text(
        modifier = Modifier
            .bottomBorder(
                divisor = 1.75f,
                strokeWidth = 1.dp,
                color = MaterialTheme.colorScheme.primary
            )
            .padding(bottom = 5.dp),
        text = title,
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
        color = MaterialTheme.colorScheme.primary
    )
}