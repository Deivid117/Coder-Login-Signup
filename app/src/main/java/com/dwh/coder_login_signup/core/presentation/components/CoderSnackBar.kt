package com.dwh.coder_login_signup.core.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CoderSnackBar(
    message: String
) {
    val containerColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val textColor = if (!isSystemInDarkTheme()) Color.White else Color.Black

    Snackbar(
        modifier = Modifier.padding(15.dp),
        containerColor = containerColor
    ) {
        Text(
            text =  message,
            style = MaterialTheme.typography.titleSmall,
            color = textColor
        )
    }
}

@Composable
fun HandleSnackBar(
    snackBarHostState: SnackbarHostState,
    isSnackBarVisible: Boolean,
    onDismissSnackBar: () -> Unit
) {
    LaunchedEffect(isSnackBarVisible) {
        if (isSnackBarVisible) {
            val snackBarResult = snackBarHostState.showSnackbar(
                message = "",
                duration = SnackbarDuration.Short
            )
            when (snackBarResult) {
                SnackbarResult.ActionPerformed -> {}
                SnackbarResult.Dismissed -> {
                    onDismissSnackBar()
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewSnackBar() {
    CoderSnackBar("Mensaje de prueba")
}