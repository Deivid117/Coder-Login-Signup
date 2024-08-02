package com.dwh.coder_login_signup.login.presentation.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.ui.UiText

@Composable
fun RememberMeCheckBox(
    modifier: Modifier = Modifier,
    onCheckedChange: (UiText) -> Unit,
) {
    var isChecked by remember { mutableStateOf(false) }
    val snackBarMessage =
        if (!isChecked) UiText.StringResource(R.string.login_snackbar_message2)
        else UiText.StringResource(R.string.login_snackbar_message3)

    Checkbox(
        checked = isChecked,
        onCheckedChange = {
            isChecked = it
            onCheckedChange(snackBarMessage)
        }
    )

    Text(
        modifier = modifier,
        text = stringResource(id = R.string.login_checkbox_remember_me),
        style = MaterialTheme.typography.labelMedium
    )
}