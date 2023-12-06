package com.example.login

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.login.ui.ForgotPassword
import com.example.login.ui.HomeScreen
import com.example.login.ui.LoginScreen
import com.example.login.ui.Registration


enum class MainScreen(@StringRes val title: Int) {
    Login(title = R.string.login),
    Registration(title = R.string.registered),
    ForgotPassword(title = R.string.ForgotPassword),
    Home(title = R.string.home),
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    currentScreen: MainScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = MainScreen.valueOf(
        backStackEntry?.destination?.route ?: MainScreen.Login.name
    )

    Scaffold(
        topBar = {
            MainAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainScreen.Login.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MainScreen.Registration.name) {
                val context = LocalContext.current
                Registration(
                    onLoginButtonClicked = {
                        navController.navigate(MainScreen.Login.name)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = MainScreen.Login.name) {
                val context = LocalContext.current
                LoginScreen(
                    onLoginButtonClicked = {
                        navController.navigate(MainScreen.Home.name)
                    },
                    onRegistered = {
                        navController.navigate(MainScreen.Registration.name)
                    },
                    onForgotPassword = {
                        navController.navigate(MainScreen.ForgotPassword.name)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = MainScreen.ForgotPassword.name) {
                val context = LocalContext.current
                ForgotPassword(
                    onLogin = {
                        navController.navigate(MainScreen.Login.name)
                    },
                    onRegistered = {
                        navController.navigate(MainScreen.Registration.name)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = MainScreen.Home.name) {
                val context = LocalContext.current
                HomeScreen(
                    onLogin = {
                        navController.navigate(MainScreen.Login.name)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }

        }
    }
}


