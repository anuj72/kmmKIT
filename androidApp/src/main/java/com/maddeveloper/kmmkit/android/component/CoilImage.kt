package com.maddeveloper.kmmkit.android.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage


@Composable
fun LoadImage(url:String="",height: Dp =250.dp,width:Dp?=null){
  CoilImage(
        imageModel = url,
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            ,
        // shows a shimmering effect when loading an image.
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = Color.LightGray,
            durationMillis = 550,
            dropOff = 0.65f,
            tilt = 10f,
        ), contentScale = ContentScale.Crop,

        // shows an error text message when request failed.
        failure = {
            Text(
                text = "Failed.",
                fontSize = 11.sp,
                fontWeight = FontWeight.Light,
            )
        },

    )
    Text(text = "Doge")
}









