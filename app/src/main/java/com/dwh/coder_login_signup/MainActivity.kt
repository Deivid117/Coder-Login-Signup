package com.dwh.coder_login_signup

import android.os.Bundle
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dwh.coder_login_signup.core.navigation.NavHost
import com.dwh.coder_login_signup.login.presentation.LoginScreen
import com.dwh.coder_login_signup.ui.theme.Coder_login_signupTheme
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Coder_login_signupTheme {
                val navController = rememberNavController()
                NavHost(navController = navController)
            }
        }
    }
}