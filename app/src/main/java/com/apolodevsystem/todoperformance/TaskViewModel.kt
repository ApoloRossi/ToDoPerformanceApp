package com.apolodevsystem.todoperformance

import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolodevsystem.todoperformance.states.TasksState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlin.random.Random

class TaskViewModel : ViewModel() {

    private var _tasks: MutableStateFlow<TasksState> = MutableStateFlow(TasksState.Loading)
    var tasksFlow: StateFlow<TasksState> = _tasks.asStateFlow()

    private var _task: MutableStateFlow<TaskModel?> = MutableStateFlow(null)
    var taskFlow: StateFlow<TaskModel?> = _task.asStateFlow()

    private var _user: MutableStateFlow<String> = MutableStateFlow("")
    var user: StateFlow<String> = _user.asStateFlow()

    init {
        getTasks()
    }

    fun getTaskById(taskId: Int) {
        _task.value = null
        viewModelScope.launch {
            delay(100)
            val task = internalTasks.find { it.id == taskId }
            _task.value = task
        }
    }

    private fun getTasks() {
        _tasks.value = TasksState.Loading
        viewModelScope.launch {
            delay(1000) // Simulating network delay

            _tasks.value = TasksState.Success(internalTasks.toList())
        }
    }

    fun getUserName(dataStore: DataStore<String>): String {
        var name = "User"
        viewModelScope.launch {
            name = dataStore.data.first()
            _user.value = name
        }
        return name
    }

    fun addTask(taskModel: TaskModel) {
        if (taskModel.id > 0) {
            var index = 0
            internalTasks.first {
                index = internalTasks.indexOf(it)
                it.id == taskModel.id
            }

            internalTasks[index] = taskModel
        } else {
            internalTasks.add(
                TaskModel(
                    Random.nextInt(1000, Int.MAX_VALUE),
                    taskModel.title,
                    taskModel.description,
                    taskModel.isCompleted
                )
            )
        }
        _tasks.value = TasksState.Success(internalTasks.toList())
    }

    fun removeTask(taskModel: TaskModel) {
        internalTasks.remove(taskModel)
        _tasks.value = TasksState.Success(internalTasks.toList())
    }

    var internalTasks = mutableListOf(
        TaskModel(1, "Task 1", "Description for Task 1", false),
        TaskModel(2, "Task 2", "Description for Task 2", true),
        TaskModel(3, "Task 3", "Description for Task 3", false),
        TaskModel(4, "Task 4", "Description for Task 4", true),
        TaskModel(5, "Task 5", "Description for Task 5", false),
        TaskModel(6, "Task 6", "Description for Task 6", false),
        TaskModel(7, "Task 7", "Description for Task 7", true),
        TaskModel(8, "Task 8", "Description for Task 8", false),
        TaskModel(9, "Task 9", "Description for Task 9", true),
        TaskModel(10, "Task 10", "Description for Task 10", false),
        TaskModel(11, "Task 11", "Description for Task 11", false),
        TaskModel(12, "Task 12", "Description for Task 12", true),
        TaskModel(13, "Task 13", "Description for Task 13", false),
        TaskModel(14, "Task 14", "Description for Task 14", true),
        TaskModel(15, "Task 15", "Description for Task 15", false)
    )
}