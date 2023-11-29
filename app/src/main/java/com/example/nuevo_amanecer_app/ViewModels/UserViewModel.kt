package com.example.nuevo_amanecer_app.ViewModels


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuevo_amanecer_app.data.LoginUserRequest
import com.example.nuevo_amanecer_app.data.LoginUserResponse
import com.example.nuevo_amanecer_app.data.RegisterUserRequest
import com.example.nuevo_amanecer_app.data.RegisterUserResponse
import com.example.nuevo_amanecer_app.service.UserService
import kotlinx.coroutines.launch
import java.lang.Exception

class UserViewModel(private val userService: UserService) : ViewModel() {

    private val _login = MutableLiveData<LoginUserResponse> ()
    val login: LiveData<LoginUserResponse> = _login

    private val _register = MutableLiveData<RegisterUserResponse> ()
    val register: LiveData<RegisterUserResponse> = _register

    fun registerUser(user: RegisterUserRequest){

        viewModelScope.launch {

            try {
                val response = userService.addUser(user)
                _register.value = response
                Log.d("UserViewModel", "registerUser: ${response.id}")
            }
            catch (e: Exception){
                Log.d("UserViewModel", "registerUser: ${e.message}")
            }
        }
    }


    fun loginUser(user: LoginUserRequest){

        _login.value = null

        viewModelScope.launch {

            try {
                val response = userService.loginUser(user)
                _login.value = response
                Log.d("UserViewModel", "loginUser: ${response.user}")
            }

            catch (e: Exception){
                Log.d("UserViewModel", "loginUser: ${e.message}")
            }
        }
    }

}