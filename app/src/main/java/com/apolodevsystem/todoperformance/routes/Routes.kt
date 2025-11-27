package com.apolodevsystem.todoperformance.routes

import com.apolodevsystem.todoperformance.TaskModel

sealed class Routes(val route : String) {

    data object TaskList : Routes("taskList")

    data object TaskScreen : Routes("taskScreen") {
        const val TASK_ID_ARG = "taskId"
        val routeWithArgs = "$route/{${TASK_ID_ARG}}"
        fun buildRoute(taskId: Int) = "$route/$taskId"
    }

}