package com.example.geez.presentation.features.registerReguler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.geez.presentation.ui.theme.GeezTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.geez.R
import com.example.geez.presentation.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeezTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val gradientColors = listOf(
                        Color(0xFFFFF176),
                        Color(0xffffEE58)
                    )
                    GradientBackground(isVerticalGradient = true, colors = gradientColors)
                    registerReguler()
                }
            }
        }
    }
}

@Preview(showBackground = true)

@Composable
fun registerReguler(
    modifier: Modifier = Modifier
){
    val gradientColorList = listOf(
        Color(0xFFF9BCDFF),
        Color(0xFFF47A3FF)
    )
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = GradientBackGroundBrush(
                    isVerticalGradient = true,
                    colors = gradientColorList
                )
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column (
            Modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
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
                    .fillMaxWidth()
                    .offset(0.dp, (-14).dp),
                style = Typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Hey, welcome!",
                color = Color.White,
                textAlign = TextAlign.Start,
                maxLines = 2,
                fontSize = 28.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, (0).dp),
                style = Typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Name",
                        color = Color.White,
                        modifier = Modifier
                            .padding(end = 232.dp),
                    )
                    TextInput(false, false)
                }
                Text(
                    text = "Email",
                    color = Color.White,

                    modifier = Modifier
                        .padding(end = 232.dp)
                )
                TextInput(false, true)
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
                TextInput(true, false)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Confirm password",
                    color = Color.White,
                    modifier = Modifier
                        .padding(end = 222.dp),
                )
                TextInput(true, false)
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .width(330.dp)
                    .height(36.dp),
                shape = RoundedCornerShape(size = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFD7DFE9)
                )
            ){
                Text(
                    text = "Register",
                    fontSize = 14.sp,
                    color = Color(0xFFF5E718D)
                )
            }

            Text(
                text = "Already have an account? Login",
                color = Color.White
            )
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

@Composable
private fun GradientBackGroundBrush(
    isVerticalGradient: Boolean,
    colors: List<Color>
): Brush {
    val endOffset = if(isVerticalGradient){
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

@Composable
private fun GradientBackground(
    isVerticalGradient: Boolean,
    colors: List<Color>
): Brush {

    val endOffset = if(isVerticalGradient){
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
fun TextInput(isPassword:Boolean, isEmail:Boolean){
    var value :String by remember { mutableStateOf("") }
    var icon: ImageVector? = null
    var eyeIcon : ImageVector? = null
    if(isPassword) {
        icon = Icons.Default.Lock
        eyeIcon = Icons.Filled.VisibilityOff
    }
    if(isEmail) icon = Icons.Filled.MailOutline
    TextField(
        value = value,
        onValueChange = {value =  it},
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(48.dp),
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
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledTextColor = Color.Transparent
        ),
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                if (eyeIcon != null) {
                    Icon(
                        imageVector = eyeIcon,
                        contentDescription = "Icon"
                    )
                }
            }
        }
    )
}