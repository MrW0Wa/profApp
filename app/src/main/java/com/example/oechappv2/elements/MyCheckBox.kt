package com.example.oechappv2.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.oechappv2.R
import com.example.oechappv2.ui.theme.Blue

@Composable
fun MyCheckBox(col: Color): Boolean {
    var flag by remember {
        mutableStateOf(false)
    }
    if (flag == false) {
        Box(
            modifier = Modifier
                .height(14.dp)
                .width(14.dp)
                .clickable { flag = !flag }
                .border(width = 1.dp, color = col, shape = RoundedCornerShape(2.dp)),
            contentAlignment = Alignment.Center
        ) {

        }
    }
    else {
        Box(
            modifier = Modifier
                .height(14.dp)
                .width(14.dp)
                .background(color = Blue, shape = RoundedCornerShape(2.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(imageVector = ImageVector.vectorResource( R.drawable.galkavector), contentDescription = null,
                modifier = Modifier.height(5.dp).clickable { flag = !flag }, alignment = Alignment.Center)
        }
    }
    return flag
}