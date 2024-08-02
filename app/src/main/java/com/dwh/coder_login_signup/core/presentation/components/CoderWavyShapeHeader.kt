package com.dwh.coder_login_signup.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dwh.coder_login_signup.R
import com.dwh.coder_login_signup.core.presentation.utils.shapes.wavyShape

@Composable
fun CoderWavyShapeHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(220.dp)
            .background(
                color = Color.Transparent,
                shape = wavyShape()
            )
            .shadow(
                elevation = 4.dp,
                shape = wavyShape(),
                ambientColor = MaterialTheme.colorScheme.onSurface,
                spotColor = MaterialTheme.colorScheme.onSurface
            )
            .padding(bottom = 6.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(wavyShape()),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            alpha = 0.4f,
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.primary,
                blendMode = BlendMode.Color
            )
        )
    }
}