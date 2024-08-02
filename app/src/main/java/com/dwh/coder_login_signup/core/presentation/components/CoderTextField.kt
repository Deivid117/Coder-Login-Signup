package com.dwh.coder_login_signup.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.ui.UiText
import com.dwh.coder_login_signup.core.presentation.utils.modifier.bottomBorder
import com.dwh.coder_login_signup.core.presentation.utils.modifier.clearFocusOnKeyboardDismiss

@Composable
fun CoderTextField(
    modifier: Modifier = Modifier,
    label: String = "",
    placeholder: String = "",
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit) = {},
    isPasswordTextField: Boolean = false,
    errorValue: UiText? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    var hidePassword by remember { mutableStateOf(true) }
    var isFocused by remember { mutableStateOf(false) }
    val backgroundColor =
        if (isFocused) MaterialTheme.colorScheme.surfaceDim else MaterialTheme.colorScheme.surfaceContainerLow
    val bottomBorderColor =
        if (errorValue != null) MaterialTheme.colorScheme.error
        else if (isFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
    val visibilityIcon = ImageVector.vectorResource(id = if (hidePassword) R.drawable.ic_visibility else R.drawable.ic_visibility_off)

    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge
        )
        BasicTextField(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp))
                .background(color = backgroundColor)
                .bottomBorder(strokeWidth = 1.dp, color = bottomBorderColor)
                .clearFocusOnKeyboardDismiss()
                .onFocusChanged { isFocused = it.isFocused },
            value = value,
            onValueChange = { onValueChange(it) },
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.tertiary),
            singleLine = true,
            visualTransformation = if (isPasswordTextField && hidePassword) PasswordVisualTransformation() else visualTransformation,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    if (!isPasswordTextField) {
                        leadingIcon()
                    } else {
                        Text(
                            modifier = Modifier.padding(horizontal = 3.dp),
                            text = "***",
                            textDecoration = TextDecoration.Underline,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                    VerticalDivider(color = MaterialTheme.colorScheme.onSurfaceVariant)

                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isBlank() && !isFocused) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = placeholder,
                                color = MaterialTheme.colorScheme.outline,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        innerTextField()
                    }

                    if (isPasswordTextField) {
                        Icon(
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable { hidePassword = !hidePassword },
                            imageVector = visibilityIcon,
                            contentDescription = "visibility icon"
                        )
                    }
                }
            }
        )

        if (errorValue != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = errorValue.asString(),
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextField() {
    CoderTextField(value = "", onValueChange = {})
}