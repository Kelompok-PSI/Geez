package com.example.geez.presentation.features.formDonation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.geez.R
import com.example.geez.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormDonation(navController: NavController) {
    var foodName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var expDate by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .padding(horizontal = 20.dp)) {
        Column(
            modifier = Modifier
                .fillMaxHeight(.9f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 25.dp, bottom = 10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.back),
                    contentDescription = "Back",
                    Modifier.clickable { navController.popBackStack() })
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Campaign Details",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
            FormField(
                name = "Food Name",
                text = foodName,
                placeholder = "Rendang Goreng",
                inputType = "string",
                onValueChange = {
                    foodName = it
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            FormField(
                name = "Quantity",
                text = quantity,
                placeholder = "Quantity: 20",
                inputType = "number",
                onValueChange = {
                    quantity = it
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            FormField(
                name = "Expired Estimation",
                text = expDate,
                placeholder = "Date: 09-09-2023",
                inputType = "string",
                onValueChange = {
                    expDate = it
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            FormField(
                name = "Pickup Location",
                text = location,
                placeholder = "Ex: Jl. Sudirman 2, Gg. 5",
                inputType = "string",
                onValueChange = {
                    location = it
                }
            )
        }
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF449EEE)),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Donate!", fontSize = 20.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormField(
    name: String,
    text: String,
    placeholder: String,
    inputType: String,
    onValueChange: (String) -> Unit
) {
    Text(
        text = name,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF3D4A5C)
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF8897AE),
            unfocusedBorderColor = Color(0xFF8897AE)
        ),
        placeholder = { Text(text = placeholder, color = Color(0xFF8897AE)) },
        keyboardOptions = KeyboardOptions(
            keyboardType = when (inputType) {
                "number" -> KeyboardType.Number
                else -> KeyboardType.Text
            }
        )
    )
}