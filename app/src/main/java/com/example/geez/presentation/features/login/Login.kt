package com.example.geez.presentation.features.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.geez.R
import com.example.geez.data.PreferencesManager
import com.example.geez.presentation.component.Loading
import com.example.geez.presentation.navigation.Screen
import com.example.geez.presentation.ui.theme.Typography

@Composable
fun Login(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)

    var localViewModel = viewModel.state.collectAsState().value
    LaunchedEffect(localViewModel) {
        if(preferencesManager.getData("token","")!==""){
            navController.navigate(Screen.CampaignList.route)
        }else {
            if (localViewModel is LoginUiState.Error) {
                Toast.makeText(context, "Username or Password is Wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    when (localViewModel) {
        is LoginUiState.Loading -> Loading()
        is LoginUiState.Success -> navController.navigate(Screen.CampaignList.route)
        else -> {}
    }

    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    val registerText = buildAnnotatedString { append("Register") }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = GradientBackGroundBrush(
                    isVerticalGradient = true,
                    colors = listOf(
                        Color(0xFFF9BCDFF),
                        Color(0xFFF47A3FF)
                    )
                )
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            Modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
                16.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Geez",
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 2,
                fontSize = 50.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, (-100).dp),
                style = Typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Glad to see\nyou come back!",
                color = Color.White,
                textAlign = TextAlign.Start,
                maxLines = 2,
                fontSize = 28.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, (-20).dp),
                style = Typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Email",
                    color = Color.White,

                    modifier = Modifier
                        .padding(end = 232.dp)
                )
                TextInput(false, true, "example@gmail.com", email, onValueChange = {
                    email = it
                })
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Password",
                    color = Color.White,
                    modifier = Modifier
                        .padding(end = 232.dp),
                )
                TextInput(true, false, "Password", password, onValueChange = {
                    password = it
                })
            }
            Button(
                onClick = { viewModel.login(email, password) },
                modifier = Modifier
                    .width(330.dp)
                    .height(36.dp),
                shape = RoundedCornerShape(size = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFD7DFE9)
                )
            ) {
                Text(
                    text = "Login",
                    fontSize = 14.sp,
                    color = Color(0xFFF5E718D)
                )
            }
            Row {
                Text(
                    text = "Already have an account?",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(2.dp))
                ClickableText(
                    text = registerText,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                    ),
                    modifier = Modifier.padding(top = 0.5.dp),
                    onClick = { navController.navigate(Screen.Register.route) },
                )
            }
        }
    }
    Image(
        painterResource(id = R.drawable.elipse_1),
        contentDescription = "elipse_1",
        modifier = Modifier
            .graphicsLayer {
                translationX = 30F
                translationY = 320F
                scaleX = 1.1F
                scaleY = 1.1F
            }
    )
    Image(
        painterResource(id = R.drawable.elipse_4),
        contentDescription = "elipse_4",
        modifier = Modifier
            .graphicsLayer {
                translationX = 0F
                translationY = 0F
                scaleX = 1.1F
                scaleY = 1.1F
            }
    )
    Image(
        painterResource(id = R.drawable.ellipse_5),
        contentDescription = "elipse_5",
        modifier = Modifier
            .graphicsLayer {
                translationX = 880F
                translationY = 700F
                scaleX = 1.1F
                scaleY = 1.1F
            }
    )
    Image(
        painterResource(id = R.drawable.elipse_1),
        contentDescription = "elipse_5",
        modifier = Modifier
            .graphicsLayer {
                translationX = 900F
                translationY = 700F
                scaleX = 0.8F
                scaleY = 0.8F
            }
    )

}

//fun showMessage(conte)

@Composable
private fun GradientBackGroundBrush(
    isVerticalGradient: Boolean,
    colors: List<Color>
): Brush {
    val endOffset = if (isVerticalGradient) {
        Offset(0f, Float.POSITIVE_INFINITY)
    } else {
        Offset(Float.POSITIVE_INFINITY, 0f)
    }

    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = endOffset
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    isPassword: Boolean,
    isEmail: Boolean,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    var isVisible by remember {
        mutableStateOf<Boolean>(false)
    }
    var icon: ImageVector? = null
    if (isPassword) {
        icon = Icons.Default.Lock
    }
    if (isEmail) icon = Icons.Filled.MailOutline


    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(52.dp),
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Icon"
                    )
                }
            }
        },
        placeholder = { Text(text = placeholder, color = Color(0xFF8897AE)) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledTextColor = Color.Transparent
        ),
        trailingIcon = {
            IconButton(onClick = {
                if (isPassword) {
                    isVisible = !isVisible
                }
            }) {
                if (isPassword) {
                    if (!isVisible){
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "Icon"
                        )
                    }else{
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "Icon"
                        )
                    }
                }
            }
        },
        visualTransformation = if (!isPassword || isVisible) VisualTransformation.None else PasswordVisualTransformation(),
    )
}