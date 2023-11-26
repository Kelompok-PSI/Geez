package com.example.geez.presentation.component

import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
fun Loading(){
    AsyncImage(
        model = "https://media.istockphoto.com/id/1302436594/video/loading-circle-icon-animation-on-white-background-4k-video-loopable-preloader.jpg?s=640x640&k=20&c=JQzv8UsXNfUnqQSULYW8B858UOM2O5CoXRgG9a0hRFk=",
        contentDescription = "loading"
    )
}