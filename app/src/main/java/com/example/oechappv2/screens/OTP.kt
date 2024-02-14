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
import androidx.compose.runtime.LaunchedEffect
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
import com.example.oechappv2.elements.MyCodeTextField
import com.example.oechappv2.elements.MyPasswordTextField
import com.example.oechappv2.elements.MyTextField
import com.example.oechappv2.ui.theme.Blue
import com.example.oechappv2.ui.theme.Gray
import com.example.oechappv2.ui.theme.LightGray
import com.example.oechappv2.ui.theme.Yellow
import kotlinx.coroutines.delay

@Composable
fun OTP(navController: NavController) {
    var values  = ArrayList<String>()
    var flag by remember {
        mutableStateOf(false)
    }
    var time by remember {
        mutableStateOf(59)
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
            Text(
                text = "OTP Verification",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                color = Gray
            )
            Text(
                text = "Enter the 6 digit numbers sent to your email",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                color = LightGray
            )
            Spacer(modifier = Modifier.height(40.dp))

            Row (modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
                values.add(MyCodeTextField())
                values.add(MyCodeTextField())
                values.add(MyCodeTextField())
                values.add(MyCodeTextField())
                values.add(MyCodeTextField())
                values.add(MyCodeTextField())

            }
            LaunchedEffect(time){
                if(time > 0) {
                    delay(1000)
                    time -= 1
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "If you didn’t receive code, ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = LightGray
                )
                if (time <= 0 ) {
                    Text(
                        text = "resend",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        color = Blue,
                    )
                }
                else{
                    Text(
                        text = "resend after $time",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        color = LightGray
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            for (i in values) {
                if (i.equals("")) {
                    flag = false
                    break
                } else flag = true
            }

            Spacer(modifier = Modifier.height(40.dp))

            BigButton(flag = flag, "Set New Password", navController, "newpass")

            Spacer(modifier = Modifier.height(15.dp))

        }
    }
}