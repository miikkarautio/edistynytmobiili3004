package com.miikka.edistynytmobiiliuusi3005

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miikka.edistynytmobiiliuusi3005.ui.theme.EdistynytMobiiliUusi3005Theme

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
                    LoginScreen()
                }
            }
        }
    }
}

//Every function is a composable
@Composable
fun LoginScreen(){

     Column(
         verticalArrangement = Arrangement.Center, //How the TextFields are setup on the screen
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         //value is set to username.value bc OutLinedTextField takes in only String type not mutable types
        OutlinedTextField(value = "", onValueChange = {newUsername -> //Set a new variable to store the new username

        }, placeholder = {
            Text(text = "Username") //Placeholder requires @composable, so using "Text" composable
        })
         Spacer(modifier = Modifier.height(16.dp))
         OutlinedTextField(value = "", onValueChange = {newPassword ->

         }, placeholder = {
             Text(text = "Password")
         })
     }
}

