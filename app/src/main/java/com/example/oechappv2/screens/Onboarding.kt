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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.oechappv2.R
import com.example.oechappv2.data.OnboardingData
import com.example.oechappv2.ui.theme.Blue
import com.example.oechappv2.ui.theme.Gray
import com.example.oechappv2.ui.theme.LightGray

@Composable
fun Onbording(navController: NavController) {

    var page by remember {
        mutableStateOf(0)
    }
    val items = ArrayList<OnboardingData>()
    items.add(
        OnboardingData(
            R.drawable.onboarding1,
            "Quick Delivery At Your\n" +
                    "Doorstep",
            "Enjoy quick pick-up and delivery to\nyour destination"
        )
    )
    items.add(
        OnboardingData(
            R.drawable.onboarding2,
            "Flexible Payment",
            "Different modes of payment either\nbefore and after delivery without\nstress"
        )
    )
    items.add(
        OnboardingData(
            R.drawable.onboarding3,
            "Real-time Tracking",
            "Track your packages/items from\nthe comfort of your home till final destination"
        )
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White), contentAlignment = Alignment.Center){
        Column (modifier = Modifier
            .fillMaxWidth(0.85f)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally){

            Image(painter = painterResource(id = items[page].image), contentDescription = null,
                modifier = Modifier.height(346.dp),
                contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(50.dp))

            Text(text = items[page].text1,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Blue)
            Text(text = items[page].text2,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color = Gray)

            Spacer(modifier = Modifier.height(110.dp))
            if(page == 2) {
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = Blue, shape = RoundedCornerShape(5.dp))
                        .clickable { navController.navigate("holder") },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
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
                        text = "Sign in",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Blue,
                        modifier = Modifier.clickable { navController.navigate("holder") }
                    )
                }
            }
            else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(100.dp)
                            .clickable { navController.navigate("holder") }
                            .border(width = 1.dp, color = Blue, shape = RoundedCornerShape(5.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Skip",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Blue
                        )
                    }
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(100.dp)
                            .clickable { page += 1 }
                            .background(color = Blue, shape = RoundedCornerShape(5.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Next",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}