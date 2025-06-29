package com.plcoding.jetpackcomposemasterclass.homework

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@PreviewScreenSizes
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun LayoutsMediumHomework() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .background(color = Color(0xFFE77356), shape = RoundedCornerShape(50f))
                .padding(6.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.wrapContentWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Outlined.CheckCircle,
                        contentDescription = null
                    )
                    Text(
                        color = Color.White,
                        modifier = Modifier.weight(1f),
                        text = "Project X",
                        fontSize = 22.sp
                    )
                    Icon(
                        modifier = Modifier.rotate(90f),
                        tint = Color.White,
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null
                    )
                }
                Text(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 34.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
                    ,
                    textAlign = TextAlign.Justify,
                    text = """
                    Bacon ipsum dolor amet pork chop flank landjaeger cupim chicken ham, tail kielbasa swine burgdoggen spare ribs meatball. Tongue burgdoggen shank meatloaf ham hock tenderloin turkey, buffalo spare ribs. Capicola tri-tip spare
                    ribs, drumstick landjaeger meatloaf chicken pork chop ground round turducken beef ribs shankle ribeye.
                    Hamburger burgdoggen shank, tri-tip jerky prosciutto rump brisket meatloaf buffalo beef ribs short ribs t-bone sausage.
                """.trimIndent()
                )
                Text(
                    color = Color.White,
                    text = "Mar 5, 10:00",
                    modifier =  Modifier.align(Alignment.End)
                )
            }
        }
    }
}