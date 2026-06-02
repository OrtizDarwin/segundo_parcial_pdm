package com.example.lvluptemplate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun InfoCard(
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(180.dp, 240.dp)
            .padding(end = 16.dp)
            .background(
                Color(0xFF1A1A1A),
                RoundedCornerShape(16.dp)
            )
            .clickable {
                onClick()
            }
            .padding(16.dp)
    ) {

        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF333333))
                    .height(150.dp)
            ) {

                AsyncImage(
                    model = "https://cdn-images.dzcdn.net/images/cover/5718f7c81c27e0b2417e2a4c45224f8a/0x1900-000000-80-0-0.jpg",

                    contentDescription = "Cover",

                    contentScale = ContentScale.Crop,

                    modifier = Modifier.matchParentSize()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Song Title",
                color = Color.White
            )

            Text(
                text = "Artist Name",
                color = Color.Gray
            )
        }
    }
}