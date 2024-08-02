package com.dwh.coder_login_signup.core.presentation.utils.visual_transformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneNumberVisualTransformation() : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.text.length >= 11) text.text.substring(0..10) else text.text

        var out = if (trimmed.isNotEmpty()) "+" else ""

        for (i in trimmed.indices) {
            if (i == 3) out += " "
            out += trimmed[i]
        }
        return TransformedText(AnnotatedString(out), phoneNumberOffsetTranslator)
    }

    private val phoneNumberOffsetTranslator = object : OffsetMapping {

        override fun originalToTransformed(offset: Int): Int =
            when (offset) {
                0  -> offset
                in 1..3 -> offset + 1
                else -> offset + 2
            }

        override fun transformedToOriginal(offset: Int): Int =
            when (offset) {
                0 -> offset
                in 1..4 -> offset - 1
                else -> offset - 2
            }

    }
}