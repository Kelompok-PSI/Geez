package com.example.geez.presentation.features.profile

import AboutProfile
import AccountSetting
import HelpCenter
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.geez.R
import com.example.geez.presentation.component.Loading
import com.example.geez.presentation.features.login.LoginUiState
import com.example.geez.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun Profile(navController: NavController,
            profileViewModel: ProfileViewModel= hiltViewModel()) {

    var localViewModel = profileViewModel.state.collectAsState().value

    when (localViewModel) {
        is ProfileUiState.LogedOut -> navController.navigate(Screen.OnBoarding.route)
        else -> {}
    }

    return Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Transparent,
                ),
                title = {
                    Row(
                        modifier = Modifier
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Profile",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.ExtraBold,
                            ),
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            "edit my profile",
                            style = TextStyle(
                                fontSize = 12.sp,
                                textDecoration = TextDecoration.Underline,
                                color = Color(0xff8897AE)
                            ),
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .clip(
                            shape = RoundedCornerShape(80.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "dummypict",
                        contentScale = ContentScale.Fit
                    )
                }
                Box(modifier = Modifier.width(20.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "Jennifer Laurent",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "+62 823 456 7890",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color(0xff8897AE),
                        ),
                    )
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xff449EEE),
                                shape = RoundedCornerShape(6.dp)
                            )
                            .padding(vertical = 2.dp, horizontal = 8.dp)
                    ) {
                        Text(
                            text = "Regular Food Giver",
                            style = TextStyle(
                                color = Color(0xffF9FAFB),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xff449EEE), shape = RoundedCornerShape(5.dp))
                    .padding(end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chips),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(80.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "Buy additional Chips here!",
                    style = TextStyle(
                        color = Color(0xffF9FAFB),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        textAlign = TextAlign.End,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(end = 12.dp),
                )
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = null, // Add appropriate content description
                    tint = Color.White
                )
            }
            AccountSetting()
            HelpCenter()
            AboutProfile()
            Button(onClick = { profileViewModel.logout()},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF574D)),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp)
                    .height(50.dp)
            ) {
                Text(text = "Log Out", fontSize = 20.sp)
            }
        }
    }
}
