package com.example.nuevo_amanecer_app.data

data class dataType(
    val name: String,
)

data class optType(
    val data: dataType,
)

data class RegisterUserRequest(
    val email: String,
    val password: String,
    val data: dataType,
)
