package com.dwh.coder_login_signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.dwh.coder_login_signup.core.navigation.Navigation
import com.dwh.coder_login_signup.ui.theme.Coder_login_signupTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }
        }

        enableEdgeToEdge()
        setContent {
            Coder_login_signupTheme {
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}