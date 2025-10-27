package com.apolodevsystem.todoperformance

import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {

    fun getTasks(): List<TaskModel> {
        // Sample data
        return listOf(
            TaskModel("Task 1", "Description for Task 1", false),
            TaskModel("Task 2", "Description for Task 2", true),
            TaskModel("Task 3", "Description for Task 3", false)
        )
    }

}