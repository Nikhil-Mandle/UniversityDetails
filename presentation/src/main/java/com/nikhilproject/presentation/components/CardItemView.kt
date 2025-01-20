package com.nikhilproject.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikhilproject.domain.model.Course
import com.nikhilproject.presentation.R

@Composable
fun CardItemView(course: Course) {
    Box(
        modifier = Modifier.padding(start = 4.dp, end = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .aspectRatio(1.0f)
                    .clip(shape = RoundedCornerShape(5.dp)),
                painter = painterResource(id = course.image),
                contentDescription = "Card Image",
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 0.dp
                    )
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = course.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = course.professor,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(12.dp))

                HorizontalDivider(thickness = 1.dp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewCardItemView(modifier: Modifier = Modifier) {
    val course =
        Course(
            name = "Course Name",
            image = R.drawable.ai_img,
            professor = "Professor Name"
        )
    CardItemView(course)
}