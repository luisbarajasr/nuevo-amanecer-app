package com.example.nuevo_amanecer_app.service

import com.example.nuevo_amanecer_app.data.LoginUserRequest
import com.example.nuevo_amanecer_app.data.LoginUserResponse
import com.example.nuevo_amanecer_app.data.RegisterUserRequest
import com.example.nuevo_amanecer_app.data.RegisterUserResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {


    companion object {
        /*
        val instance: UserService = Retrofit.Builder().baseUrl("https://login-api-dev-dctx.3.us-1.fl0.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserService::class.java)
         */
        // use https://bfmvwivyerrefrhrlmxx.supabase.co/auth/v1/signup
        // with header apikey = eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJmbXZ3aXZ5ZXJyZWZyaHJsbXh4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NjE0MzAyMTQsImV4cCI6MTk3NzAwNjIxNH0.qVfVNzYGkQ6s17S-9xW1Lq-ZwTEumsGsNI5yaHUqSWY
        val instance: UserService = Retrofit.Builder().baseUrl("https://bfmvwivyerrefrhrlmxx.supabase.co/auth/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserService::class.java)

    }

    //@POST("api/users/add")
    //suspend fun addUser(@Body user:RegisterUserRequest) : RegisterUserResponse
    @POST("signup")
    suspend fun addUser(@Body user: RegisterUserRequest, @Header("apikey") apikey: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJmbXZ3aXZ5ZXJyZWZyaHJsbXh4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NjE0MzAyMTQsImV4cCI6MTk3NzAwNjIxNH0.qVfVNzYGkQ6s17S-9xW1Lq-ZwTEumsGsNI5yaHUqSWY") : RegisterUserResponse

    //@POST("api/users/login")
    //suspend fun loginUser(@Body user:LoginUserRequest) : LoginUserResponse
    @POST("token?grant_type=password")
    suspend fun loginUser(@Body user: LoginUserRequest, @Header("apikey") apikey: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJmbXZ3aXZ5ZXJyZWZyaHJsbXh4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NjE0MzAyMTQsImV4cCI6MTk3NzAwNjIxNH0.qVfVNzYGkQ6s17S-9xW1Lq-ZwTEumsGsNI5yaHUqSWY") : LoginUserResponse


}