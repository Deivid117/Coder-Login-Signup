package com.dwh.coder_login_signup.core.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun CoderScaffold(
    snackBarMessage: String = "",
    isSnackBarVisible: Boolean = false,
    onDismissSnackBar: () -> Unit = {},
    content: @Composable() () -> Unit = {}
) {
    val snackBarHostState = remember { SnackbarHostState() }

    HandleSnackBar(
        snackBarHostState = snackBarHostState,
        isSnackBarVisible = isSnackBarVisible,
        onDismissSnackBar = { onDismissSnackBar() }
    )

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackBarHostState) {
                CoderSnackBar(message = snackBarMessage)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }
}
