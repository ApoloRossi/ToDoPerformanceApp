package com.apolodevsystem.todoperformance.states

import com.apolodevsystem.todoperformance.TaskModel

sealed class TasksState {
    object Loading : TasksState()
    data class Success(val tasks: List<TaskModel>) : TasksState()
}