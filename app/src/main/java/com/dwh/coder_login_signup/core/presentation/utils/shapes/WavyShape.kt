package com.dwh.coder_login_signup.core.presentation.utils.shapes

import androidx.compose.foundation.shape.GenericShape

fun wavyShape() = GenericShape { size, _ ->
    val width = size.width
    val height = size.height

    moveTo(0f, height * 0.8f)
    quadraticBezierTo(
        width * 0.25f, height * 0.5f,
        width * 0.5f, height * 0.8f
    )
    quadraticBezierTo(
        width * 0.75f, height * 1.1f,
        width, height * 0.75f
    )
    lineTo(width, 0f)
    lineTo(0f, 0f)
    close()
}