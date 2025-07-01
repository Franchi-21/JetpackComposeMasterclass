package com.plcoding.jetpackcomposemasterclass.homework.states.hard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.UUID

class TodoListViewModel : ViewModel() {
    private val _tasks = MutableStateFlow(TodoListState())
    val tasks = _tasks.asStateFlow()

    fun onEvent(event: TodoListEvent) {
        when (event) {
            is TodoListEvent.AddTask -> {
                _tasks.update {
                    it.copy(
                        tasks = it.tasks + TodoTask(
                            taskId = it.tasks.size + 1,
                            title = it.title,
                            desc = it.desc,
                            isChecked = false
                        )
                    )
                }
                _tasks.update { it.copy(title = "", desc = "") }
            }

            is TodoListEvent.RemoveTask -> {
                _tasks.update {
                    it.copy(
                        tasks = it.tasks - event.task
                    )
                }
            }

            is TodoListEvent.ChangeCheckedState -> {
                val index = _tasks.value.tasks.indexOf(event.task)
                _tasks.update {
                    it.copy(
                        tasks = it.tasks.toMutableList().apply {
                            this[index] = event.task.copy(isChecked = event.isChecked)
                        }
                    )
                }
            }

            is TodoListEvent.UpdateTitle -> {
                _tasks.update { it.copy(title = event.title) }
            }

            is TodoListEvent.UpdateDesc -> {
                _tasks.update { it.copy(desc = event.desc) }
            }
        }
    }
}

data class TodoListState(
    val title: String = "",
    val desc: String = "",
    val tasks: List<TodoTask> = listOf()
)

data class TodoTask(
    val taskId: Int,
    val title: String,
    val desc: String,
    val isChecked: Boolean
)

sealed class TodoListEvent {
    data object AddTask : TodoListEvent()
    data class RemoveTask(val task: TodoTask) : TodoListEvent()
    data class ChangeCheckedState(val task: TodoTask, val isChecked: Boolean) : TodoListEvent()
    data class UpdateTitle(val title: String) : TodoListEvent()
    data class UpdateDesc(val desc: String) : TodoListEvent()
}