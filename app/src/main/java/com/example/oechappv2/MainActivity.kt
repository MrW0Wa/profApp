package com.example.oechappv2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oechappv2.screens.Forgot
import com.example.oechappv2.screens.Holder
import com.example.oechappv2.screens.Home
import com.example.oechappv2.screens.LogIn
import com.example.oechappv2.screens.NewPass
import com.example.oechappv2.screens.OTP
import com.example.oechappv2.screens.Onbording
import com.example.oechappv2.screens.SignUp
import com.example.oechappv2.ui.theme.OECHAppV2Theme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    private val viewModel : SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition{viewModel.isLoading.value}
        setContent {
            OECHAppV2Theme {
                preview()
            }
        }
    }
}

@Preview
@Composable
fun preview() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "signup"){
        composable("onboarding"){
            Onbording(navController = navController)
        }
        composable("holder"){
            Holder()
        }
        composable("signup"){
            SignUp(navController)
        }
        composable("login"){
            LogIn(navController = navController)
        }
        composable("forgot"){
            Forgot(navController = navController)
        }
        composable("otp"){
            OTP(navController = navController)
        }
        composable("newpass"){
            NewPass(navController = navController)
        }
        composable("home"){
            Home()
        }

    }

}