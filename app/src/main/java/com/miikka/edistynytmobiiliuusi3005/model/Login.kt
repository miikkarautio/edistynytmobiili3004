package com.miikka.edistynytmobiiliuusi3005.model

// data class that holds the username and password for the login
data class LoginReqModel(
    val username: String = "",
    val password: String = "",
    val loading: Boolean = false
)

data class LoginResModel(
    val id: Int = 0,
    val accessToken: String = "",
    val username: String = ""
)
