package com.example.nuevo_amanecer_app.data

data class user_metadataType(
    val name: String,
)
data class userType(
    val id: String,
    val aud: String,
    val email: String,
    val user_metadata: user_metadataType,
)

data class LoginUserResponse(
    val user: userType,
    val access_token: String,
)