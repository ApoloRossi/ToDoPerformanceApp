package com.apolodevsystem.todoperformance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val taskViewModel : TaskViewModel by inject()
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "taskList") {
                composable ("taskList") {
                    TasksListScreenComponent(navController, taskViewModel)
                }
                composable ("taskScreen") {
                    TaskScreenComponent(navController, taskViewModel)
                }
            }
        }
    }
}