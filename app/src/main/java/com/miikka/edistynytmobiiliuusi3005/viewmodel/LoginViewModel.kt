package com.miikka.edistynytmobiiliuusi3005.viewmodel

import androidx.compose.material3.Icon
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miikka.edistynytmobiiliuusi3005.model.LoginReqModel //Import LoginReqModel model/Login.kt
import com.miikka.edistynytmobiiliuusi3005.model.LoginResModel //Import LoginResModel model/Login.kt
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginState = mutableStateOf(LoginReqModel()) //Creates mutableStateOf from LoginReqModel that secures login data.
    val loginState: State<LoginReqModel> = _loginState

    //Sets both the username and the password. This is lastly used in Main activity
    fun setUsername(newUsername: String){
        _loginState.value = _loginState.value.copy(username = newUsername)
    }

    fun setPassword(newPassword: String){
        _loginState.value = _loginState.value.copy(password = newPassword)
    }

    suspend fun _waitForLogin(){
        delay(2000)
    }

    fun login(){

        viewModelScope.launch {
            _loginState.value = _loginState.value.copy(loading = true)
            _waitForLogin() //put _waitForLogin inside viewModelScope so that the fun doesn't need to be a suspend function
            val user = LoginResModel()
            _loginState.value = _loginState.value.copy(loading = false)

        }
    }

}