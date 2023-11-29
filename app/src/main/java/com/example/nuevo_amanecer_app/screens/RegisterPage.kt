package com.example.nuevo_amanecer_app.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nuevo_amanecer_app.R
import com.example.nuevo_amanecer_app.data.RegisterUserRequest
import com.example.nuevo_amanecer_app.service.UserService
import com.example.nuevo_amanecer_app.ViewModels.UserViewModel
import androidx.compose.ui.graphics.Color
import com.example.nuevo_amanecer_app.data.dataType


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterPage(navController: NavHostController) {

    val snackbarHostState = remember { SnackbarHostState() }
    val userviewModel = UserViewModel(UserService.instance)

    val name = remember { mutableStateOf("") }

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val registerState = userviewModel.register.observeAsState()

    LaunchedEffect(key1 = registerState.value?.id) {

        registerState.value?.let {
            snackbarHostState.showSnackbar(it.id)
            navController.navigate("MenuScreen")
        }
    }

    Row {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.nuevo_amanecer),
                contentDescription = "sdf",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(16.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(color = Color(android.graphics.Color.parseColor("#5BC0EB"))),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {

            Text("REGISTRO", fontSize = 35.sp, fontWeight = FontWeight.Bold, color = Color.White)

            OutlinedTextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                placeholder = {
                    Text("Nombre")
                },
                shape = RoundedCornerShape(45.dp),
                modifier = Modifier.padding(10.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            )

            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                shape = RoundedCornerShape(45.dp),
                placeholder = {
                    Text("Email")
                }
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                shape = RoundedCornerShape(45.dp),
                placeholder = {
                    Text("Contraseña")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
            )

            Button(
                onClick = {

                    // Update this to create a user with the name included
                    val user = RegisterUserRequest(email = email.value, password = password.value, data = dataType(name = name.value))
                    val asd = userviewModel.registerUser(user)
                    Log.d("asd", asd.toString())
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary, // Use primary color from the theme
                    contentColor = MaterialTheme.colorScheme.onPrimary // Use onPrimary color for content
                )

            ){
                Text(text = "Registrar", color = MaterialTheme.colorScheme.onPrimary )
            }

            Button(onClick = {
                navController.navigate("LoginPage")
            }) {
                Text(text ="Regresar")
            }

            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}


