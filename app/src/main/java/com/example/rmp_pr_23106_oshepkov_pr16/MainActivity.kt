package com.example.rmp_pr_23106_oshepkov_pr16

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Boxgit
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.rmp_pr_23106_oshepkov_pr16.ui.theme.RMP_PR_23106_Oshepkov_PR16Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "screen1") {
                composable("screen1") { OnboardingScreen(navController) }
                composable("screen2") { LoginScreen(navController) }
            }
        }
        // Install the splash screen
        val splashScreen = installSplashScreen()

        // Optional: Control how long the splash screen stays visible
        var keepSplashScreen = true

        lifecycleScope.launch {
            // Simulate loading data or any necessary operations
            delay(2000) // Duration for which the splash screen is shown
            keepSplashScreen = false
        }

        splashScreen.setKeepOnScreenCondition { keepSplashScreen }

        setContent {
            // Your main content goes here
            MyAppContent()
        }
        enableEdgeToEdge()
        setContent {
            RMP_PR_23106_Oshepkov_PR16Theme {
                MainScreen()
            }
        }
    }
}
@Composable
fun MyAppContent() {
    // Your main UI components go here
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}
@Composable
fun OnboardingScreen() {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .offset(y = (-85).dp)
        )
        Text(
            text = "ПРИВЕТ",
            color = Color.White,
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 70.dp)
        )
        Text(
            text = "Наслаждайся отборочными.\nБудь внимателен.\nДелай хорошо.",
            color = Color.White,
            style = TextStyle(fontSize = 20.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 120.dp)
        )
        Button(
            onClick = {navController.navigate("screen2")},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C9A92)),
            modifier = Modifier
                .width(320.dp)
                .height(60.dp)
                .align(Alignment.Center)
                .offset(y = 300.dp)
        ) {
            Text(
                text = "Войти в аккаунт",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Text(
            text = "Еще нет аккаунта? Зарегистрируйтесь",
            color = Color.White,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 360.dp)
                .clickable(onClick = { /* Действие при нажатии */ })
        )
    }
}
@Composable
fun LoginScreen(navController: NavController) {
    Box(modifier = Modifier
        .background(Color(0xFF253334))
        .fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.login_logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
        )
        Text(
            text = "Email",
            color = Color.White,
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier
                .padding(bottom = 5.dp)
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 120.dp)
                .alpha(0.7f)
        ) {
            Text(
                text = "Email",
                color = Color.White,
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth(0.8f)
                    .background(Color.White)
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 50.dp)
                .alpha(0.7f)
        ) {
            Text(
                text = "Пароль",
                color = Color.White,
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth(0.8f)
                    .background(Color.White)
            )
        }
        Button(
            onClick = {/* Действие при нажатии */},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C9A92)),
            modifier = Modifier
                .width(320.dp)
                .height(60.dp)
                .align(Alignment.Center)
                .offset(y = 130.dp)
        ) {
            Text(
                text = "Sign in",
                color = Color.White,
                style = TextStyle(fontSize = 25.sp)
            )
        }
        Text(
            text = "Register",
            color = Color.White,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .padding(bottom = 5.dp)
        )
        Button(
            onClick = {/* Действие при нажатии */},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C9A92)),
            modifier = Modifier
                .width(320.dp)
                .height(60.dp)
                .align(Alignment.Center)
                .offset(y = 270.dp)
        ) {
            Text(
                text = "Профиль",
                color = Color.White,
                style = TextStyle(fontSize = 25.sp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.login_leafes),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}
@Composable
fun SignInScreen() {
    Box(modifier = Modifier
        .background(Color(0xFF253334))
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .width(200.dp)
        ) {
            Text(
                text = "Тут будет регистрация",
                color = Color.White,
                fontFamily = FontFamily.Serif,
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier
                    .padding(bottom = 5.dp)
            )
        }
}
}
@Composable
fun MainScreen() {
    Box(modifier = Modifier
        .background(Color(0xFF253334))
        .fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
                .padding(horizontal = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.hamburger), // Замените на ваш ресурс
                contentDescription = null,
            )
            Image(
                painter = painterResource(id = R.drawable.logo), // Замените на ваш ресурс
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ellipse_2), // Замените на ваш ресурс
                contentDescription = null,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RMP_PR_23106_Oshepkov_PR16Theme {
        OnboardingScreen()
    }
}