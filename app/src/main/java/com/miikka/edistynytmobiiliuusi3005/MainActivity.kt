package com.miikka.edistynytmobiiliuusi3005

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import com.miikka.edistynytmobiiliuusi3005.ui.theme.EdistynytMobiiliUusi3005Theme
import com.miikka.edistynytmobiiliuusi3005.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdistynytMobiiliUusi3005Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()
                    val navController = rememberNavController()
                    ModalNavigationDrawer(
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        drawerContent = {
                            ModalDrawerSheet {
                                Spacer(modifier = Modifier.height(16.dp))
                                NavigationDrawerItem(
                                    label = { Text(text = "Categories") },
                                    selected = true,
                                    onClick = { scope.launch { drawerState.close() } }, icon = {
                                        Icon(
                                            imageVector = Icons.Filled.Home,
                                            contentDescription = "Home")
                                    })
                                NavigationDrawerItem(
                                    label = { Text(text = "Login") },
                                    selected = false,
                                    onClick = { scope.launch {
                                        navController.navigate("loginScreen")
                                        drawerState.close()
                                    } }, icon = {
                                        Icon(
                                            imageVector = Icons.Filled.Lock,
                                            contentDescription = "Lock")
                                    })
                            }
                        }, drawerState = drawerState) {
                        NavHost(navController = navController, startDestination = "categoriesScreen"){
                            composable(route = "categoriesScreen"){
                                CategoriesScreen(onMenuClick = {
                                    scope.launch{drawerState.open()}
                                })
                            }
                            composable(route = "loginScreen"){
                                LoginScreen(goToCategories = {
                                    navController.navigate("categoriesScreen")
                                })
                            }
                        }


                    }
                }
            }
        }
    }
}

//Every function is a composable


