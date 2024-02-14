package com.example.oechappv2.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oechappv2.ui.theme.Light
import com.example.oechappv2.ui.theme.LightGray
import androidx.compose.material.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import com.example.oechappv2.R
import com.example.oechappv2.ui.theme.Blue

@Composable
fun MyTextField(onText : String, text : String): String {
    var value by remember {
        mutableStateOf("")
    }
    Text(text = onText,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Start,
        color = LightGray
    )
    Spacer(modifier = Modifier.height(5.dp))
    OutlinedTextField(value = value, onValueChange ={value = it},
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = LightGray,
            focusedBorderColor = LightGray
        ),
        placeholder = {
            Text(text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                color = Light
            )
        })
    return value
}
@Composable
fun MyPasswordTextField(onText : String, text : String): String {
    var value by remember {
        mutableStateOf("")
    }
    Text(text = onText,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Start,
        color = LightGray
    )
    Spacer(modifier = Modifier.height(5.dp))
    OutlinedTextField(value = value, onValueChange ={value = it},
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = LightGray,
            focusedBorderColor = LightGray,
        ),
        placeholder = {
            Text(text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                color = Light
            )
        },
        trailingIcon = { Image(imageVector = ImageVector.vectorResource(id = R.drawable.eyevector),
            contentDescription = null,
        modifier = Modifier
            .height(14.dp)
            .width(14.dp))},
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
    return value
}
@Composable
fun MyCodeTextField(): String {
    var value by remember {
        mutableStateOf("")
    }
    var col by remember {
        mutableStateOf(LightGray)
    }
    if (!value.equals("")) col = Blue
    else col = LightGray

    Box(contentAlignment = Alignment.Center) {
        OutlinedTextField(
            value = value, onValueChange = { value = it },
            modifier = Modifier
                .height(32.dp)
                .width(32.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = col,
                focusedBorderColor = LightGray
            ),
            shape = RoundedCornerShape(0.dp),
            maxLines = 1
        )
        Text(text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            color = Color.Black
        )
    }
    return value
}