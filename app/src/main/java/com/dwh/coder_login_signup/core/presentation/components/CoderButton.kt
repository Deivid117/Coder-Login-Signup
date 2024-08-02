package com.dwh.coder_login_signup.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CoderButton(
    modifier: Modifier = Modifier,
    buttonName: String = "",
    color: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    Column(Modifier.padding(horizontal = 30.dp)) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .background(color = color)
                .clickable { onClick() }
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = buttonName,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCoderButton() {
    CoderButton(Modifier.fillMaxWidth()) {}
}