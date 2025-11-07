package com.apolodevsystem.todoperformance.routes

sealed class Routes {

    class TaskList() : Routes() {
        companion object {
            const val route = "taskList"
        }
    }

    class TaskScreen() : Routes() {
        companion object {
            const val route = "taskScreen"
        }
    }

}