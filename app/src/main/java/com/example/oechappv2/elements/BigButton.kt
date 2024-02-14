package com.example.oechappv2.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.oechappv2.ui.theme.Blue
import com.example.oechappv2.ui.theme.LightGray
import com.example.oechappv2.ui.theme.Yellow

@Composable
fun BigButton(flag : Boolean, text: String, navController: NavController, link: String) {
    if (flag == false) {
        Box(
            modifier = Modifier.fillMaxWidth().height(46.dp)
                .background(color = LightGray, shape = RoundedCornerShape(4.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = Color.White
            )
        }
    }
    else {
        Box(
            modifier = Modifier.fillMaxWidth().height(46.dp)
                .background(color = Blue, shape = RoundedCornerShape(4.dp))
                .clickable { navController.navigate(link) },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = Color.White
            )
        }
    }
}