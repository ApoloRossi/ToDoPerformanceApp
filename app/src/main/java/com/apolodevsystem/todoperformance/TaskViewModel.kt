package com.apolodevsystem.todoperformance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolodevsystem.todoperformance.states.TasksState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {

    private var _tasks : MutableStateFlow<TasksState> = MutableStateFlow(TasksState.Loading)
    var tasksFlow : StateFlow<TasksState> = _tasks.asStateFlow()

    init {
        getTasks()
    }

    private fun getTasks() {
        _tasks.value = TasksState.Loading
        viewModelScope.launch {
            delay(1000) // Simulating network delay
            val tasks = listOf(
                TaskModel("Task 1", "Description for Task 1", false),
                TaskModel("Task 2", "Description for Task 2", true),
                TaskModel("Task 3", "Description for Task 3", false),
                TaskModel("Task 4", "Description for Task 4", true),
                TaskModel("Task 5", "Description for Task 5", false),
                TaskModel("Task 6", "Description for Task 6", false),
                TaskModel("Task 7", "Description for Task 7", true),
                TaskModel("Task 8", "Description for Task 8", false),
                TaskModel("Task 9", "Description for Task 9", true),
                TaskModel("Task 10", "Description for Task 10", false),
                TaskModel("Task 11", "Description for Task 11", false),
                TaskModel("Task 12", "Description for Task 12", true),
                TaskModel("Task 13", "Description for Task 13", false),
                TaskModel("Task 14", "Description for Task 14", true),
                TaskModel("Task 15", "Description for Task 15", false),
                TaskModel("Task 16", "Description for Task 16", false),
                TaskModel("Task 17", "Description for Task 17", true),
                TaskModel("Task 18", "Description for Task 18", false),
                TaskModel("Task 19", "Description for Task 19", true),
                TaskModel("Task 20", "Description for Task 20", false),
                TaskModel("Task 21", "Description for Task 21", false),
                TaskModel("Task 22", "Description for Task 22", true),
                TaskModel("Task 23", "Description for Task 23", false),
                TaskModel("Task 24", "Description for Task 24", true),
                TaskModel("Task 25", "Description for Task 25", false),
                TaskModel("Task 26", "Description for Task 26", false),
                TaskModel("Task 27", "Description for Task 27", true),
                TaskModel("Task 28", "Description for Task 28", false),
                TaskModel("Task 29", "Description for Task 29", true),
                TaskModel("Task 30", "Description for Task 30", false),
                TaskModel("Task 31", "Description for Task 31", false),
                TaskModel("Task 32", "Description for Task 32", true),
                TaskModel("Task 33", "Description for Task 33", false)
            )
            _tasks.value = TasksState.Success(tasks)
        }

    }

}