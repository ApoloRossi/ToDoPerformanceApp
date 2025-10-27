package com.apolodevsystem.todoperformance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "taskList") {
                composable ("taskList") {
                    val taskViewModel : TaskViewModel by inject()
                    TasksListScreenComponent(navController, taskViewModel)
                }
                composable ("taskScreen") { TaskScreenComponent(navController) }
            }
        }
    }
}