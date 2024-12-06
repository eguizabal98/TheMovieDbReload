package com.eem.themoviedbreload

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.eem.themoviedbreload.navigation.AppNavigationHost
import com.eem.themoviedbreload.ui.theme.TheMovieDbReloadTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val snackBarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()

            TheMovieDbReloadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigationHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        showSnackBar = { message, withDismissAction, duration ->
                            scope.launch {
                                snackBarHostState.showSnackbar(
                                    message = message,
                                    withDismissAction = withDismissAction,
                                    duration = duration
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheMovieDbReloadTheme {
        Greeting("Android")
    }
}
