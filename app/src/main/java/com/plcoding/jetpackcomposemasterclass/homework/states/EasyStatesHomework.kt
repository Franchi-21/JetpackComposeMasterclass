package com.plcoding.jetpackcomposemasterclass.homework.states

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun EasyStatesHomework(innerPadding: PaddingValues) {
    var checked by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color(0xFFfe3f6f), shape = RoundedCornerShape(6.dp))
            .padding(6.dp),
    ) {
        Column {
            Text(
                textDecoration = if (checked) TextDecoration.LineThrough else null,
                color = Color.White,
                text = "Bring out the trash",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                textDecoration = if (checked) TextDecoration.LineThrough else null,
                color = Color.White,
                text = "Better do this before wife comes home"
            )
        }
        Spacer(Modifier.weight(1f))
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}

@Preview
@Composable
private fun EasStatesHomeworkPreview() {
    JetpackComposeMasterclassTheme {
        EasyStatesHomework(PaddingValues())
    }
}