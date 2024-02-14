package com.example.oechappv2.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.oechappv2.R
import com.example.oechappv2.data.OnboardingData
import com.example.oechappv2.elements.BigButton
import com.example.oechappv2.elements.MyCheckBox
import com.example.oechappv2.elements.MyPasswordTextField
import com.example.oechappv2.elements.MyTextField
import com.example.oechappv2.ui.theme.Blue
import com.example.oechappv2.ui.theme.Gray
import com.example.oechappv2.ui.theme.LightGray
import com.example.oechappv2.ui.theme.Yellow
@Composable
fun LogIn(navController: NavController) {
    var values  = ArrayList<String>()
    var flag by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.TopCenter){
        Column(modifier = Modifier
            .fillMaxWidth(0.85f)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start) {
            Spacer(modifier = Modifier.height(130.dp))
            Text(text = "Welcome Back",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                color = Gray)
            Text(text = "Fill in your email and password to continue",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                color = LightGray)
            Spacer(modifier = Modifier.height(25.dp))
            values.add(MyTextField(onText = "Email Address", text = "***********@mail.com"))
            Spacer(modifier = Modifier.height(15.dp))
            values.add(MyPasswordTextField(onText = "Password", text = "**********"))
            Spacer(modifier = Modifier.height(20.dp))

            for(i in values){
                if (i.equals("")) {
                    flag = false
                    break
                }
                else flag = true
            }


            Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

                Row {
                    MyCheckBox(LightGray)
                    Text(
                        text = " Remember password",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start,
                        color = LightGray
                    )
                }
                Text(text = "Forgot Password?",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start,
                    color = Blue,
                    modifier = Modifier.clickable { navController.navigate("forgot") })
            }

            Spacer(modifier = Modifier.height(170.dp))

            BigButton(flag = flag, "Log in", navController, "home")

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already have an account?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = LightGray
                )
                Text(
                    text = "Sign Up",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = Blue,
                    modifier = Modifier.clickable { navController.navigate("signup") }
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "or sign in using",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = LightGray
                )

            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.googleicovector),
                    contentDescription = null,
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp))

            }
            Spacer(modifier = Modifier.height(25.dp))
        }
    }
}