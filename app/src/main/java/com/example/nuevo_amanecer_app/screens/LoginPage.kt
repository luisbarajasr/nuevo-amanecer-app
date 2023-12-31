package com.example.nuevo_amanecer_app.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.nuevo_amanecer_app.data.LoginUserRequest
import androidx.compose.ui.graphics.Color
import com.example.nuevo_amanecer_app.ViewModels.UserViewModel
import com.example.nuevo_amanecer_app.service.UserService

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginPage(navController: NavHostController) {

    val snackbarHostState = remember { SnackbarHostState() }
    val userviewModel = UserViewModel(UserService.instance)


    val name = remember {
        mutableStateOf("")
    }

    val matricula = remember {
        mutableStateOf("")
    }

    //val loginState = userviewModel.login.observeAsState()
    val loginState = userviewModel.login.observeAsState()

    LaunchedEffect(key1 = loginState.value?.user?.user_metadata){

        loginState.value?.let {
            if(loginState?.value?.access_token != ""){
                navController.navigate("MenuScreen")
            }
            else {
                snackbarHostState.showSnackbar("Error al iniciar sesión")
            }

        }
    }

    Row {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(color = Color(android.graphics.Color.parseColor("#469BE5"))),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.nuevo_amanecer2),
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
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {

            Text("INICIO DE SESIÓN", fontSize = 35.sp, fontWeight = FontWeight.Bold, color = Color.Black)


            OutlinedTextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                shape = RoundedCornerShape(45.dp),
                placeholder = {
                    Text("Email")
                }
            )

            OutlinedTextField(
                value = matricula.value,
                onValueChange = {
                    matricula.value = it
                },
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                shape = RoundedCornerShape(45.dp),
                placeholder = {
                    Text("Contraseña")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
            )

            Button(onClick = {

                val user = LoginUserRequest(name.value, matricula.value)
                userviewModel.loginUser(user)


            }) {
                Text(text = "Ingresar")
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { navController.navigate("RegisterPage") }
                    .padding(8.dp)
            ) {
                Text(
                    text = "¿No tienes cuenta?",
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Text(
                    text = "Regístrate",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}