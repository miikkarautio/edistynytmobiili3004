package com.miikka.edistynytmobiiliuusi3005

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CategoriesScreen(onMenuClick: () -> Unit){
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Categories")}, navigationIcon = {
            IconButton(onClick = { onMenuClick() }) { //Create button
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu") //Set button image
            }
    })
    }) {
        LazyColumn(modifier = Modifier.padding(it)){}
    }
}