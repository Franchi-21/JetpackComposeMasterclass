package com.plcoding.jetpackcomposemasterclass.homework.states.hard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun HardStatesHomework(paddingValues: PaddingValues, viewModel: TodoListViewModel = viewModel()) {
    val state = viewModel.tasks.collectAsStateWithLifecycle().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(8.dp)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            if (state.tasks.isNotEmpty()) {
                items(
                    items = state.tasks,
                    key = { it.taskId }
                ) { task ->
                    TodoItem(
                        task = task,
                        onEvent = viewModel::onEvent,
                        modifier = Modifier.animateItem()
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextField(
                    value = state.title,
                    placeholder = { Text(text = "Title") },
                    onValueChange = { viewModel.onEvent(TodoListEvent.UpdateTitle(it)) }
                )
                TextField(
                    value = state.desc,
                    onValueChange = { viewModel.onEvent(TodoListEvent.UpdateDesc(it)) },
                    placeholder = { Text(text = "Description") }
                )
            }
            Button(
                modifier = Modifier.align(Alignment.CenterVertically),
                onClick = {
                    viewModel.onEvent(TodoListEvent.AddTask)
                }
            ) {
                Text(text = "Add")
            }
        }
    }
}

@Composable
fun TodoItem(
    modifier: Modifier,
    task: TodoTask,
    onEvent: (TodoListEvent) -> Unit,
) {
    Row(
        modifier = modifier
            .wrapContentSize()
            .background(color = Color(0xFFfe3f6f), shape = RoundedCornerShape(6.dp))
            .padding(6.dp),
    ) {
        Column {
            Text(
                textDecoration = if (task.isChecked) TextDecoration.LineThrough else null,
                color = Color.White,
                text = task.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                textDecoration = if (task.isChecked) TextDecoration.LineThrough else null,
                color = Color.White,
                text = task.desc
            )
        }
        Spacer(Modifier.weight(1f))
        Checkbox(
            colors = CheckboxDefaults.colors(
                checkedColor = Color.White,
                uncheckedColor = Color.White,
                checkmarkColor = Color.Black
            ),
            checked = task.isChecked,
            onCheckedChange = {
                onEvent(TodoListEvent.ChangeCheckedState(task, it))
            }
        )
        IconButton(
            onClick = { onEvent(TodoListEvent.RemoveTask(task)) }
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun TodoItemPreview() {
    JetpackComposeMasterclassTheme {
        TodoItem(
            task = TodoTask(
                title = "Bring out the trash",
                desc = "Better do this before wife comes home",
                isChecked = false,
                taskId = 1
            ),
            onEvent = {},
            modifier = Modifier
        )
    }
}