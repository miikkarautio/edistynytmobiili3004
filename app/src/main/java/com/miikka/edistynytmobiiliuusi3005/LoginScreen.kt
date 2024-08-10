package com.miikka.edistynytmobiiliuusi3005
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miikka.edistynytmobiiliuusi3005.viewmodel.LoginViewModel

@Composable
fun LoginScreen(goToCategories: () -> Unit){

    val loginVm: LoginViewModel = viewModel() //Create new viewModel from viewmodel/LoginViewModel

    Box {//Inside a box so that ProgessIndicator can be aligned
        when {
            loginVm.loginState.value.loading -> CircularProgressIndicator(modifier = Modifier.align(
                Alignment.Center))
            else -> Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, //How the TextFields are setup on the screen
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //value is set to username.value bc OutLinedTextField takes in only String type not mutable types
                OutlinedTextField(value = loginVm.loginState.value.username, onValueChange = {newUsername -> //Set a new variable to store the new username
                    loginVm.setUsername(newUsername)
                }, placeholder = {
                    Text(text = "Username") //Placeholder requires @composable, so using "Text" composable
                })
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = loginVm.loginState.value.password, onValueChange = {newPassword ->
                    loginVm.setPassword(newPassword)
                }, placeholder = {
                    Text(text = "Password")
                }, visualTransformation = PasswordVisualTransformation())
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    enabled = loginVm.loginState.value.username != "" && loginVm.loginState.value.password != "",
                    onClick = {
                        loginVm.login()
                        goToCategories()
                    }) {
                    Text(text = "Login")
                }
            }
        }
    }


}