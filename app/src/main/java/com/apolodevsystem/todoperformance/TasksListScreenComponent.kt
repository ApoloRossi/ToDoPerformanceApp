package com.apolodevsystem.todoperformance

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apolodevsystem.todoperformance.routes.Routes
import com.apolodevsystem.todoperformance.states.TasksState
import com.apolodevsystem.todoperformance.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksListScreenComponent(navController: NavController, taskViewModel: TaskViewModel) {
    AppTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "ToDo Performance") }
            )
        }, floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Routes.TaskScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Task"
                )
            }

        }) { innerPadding ->
            val state = taskViewModel.tasksFlow.collectAsStateWithLifecycle().value
            when (state) {
                is TasksState.Loading -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Text("Loading...", modifier = Modifier.padding(16.dp))
                    }
                }

                is TasksState.Success -> {
                    val tasks = state.tasks
                    ItemsList(
                        tasks,
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    ) {
                        taskViewModel.removeTask(it)
                    }
                }
            }
        }
    }
}

@Composable
fun ItemsList(
    tasks: List<TaskModel>,
    modifier: Modifier = Modifier,
    navController: NavController,
    itemClicked: (TaskModel) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)) {
        tasks.forEach { task ->
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    )
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                navController.navigate(Routes.TaskScreen.buildRoute(task.id))
                            }
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(task.title)
                            Text(task.description)
                            Text("Completed: ${task.isCompleted}")
                        }

                        IconButton(
                            content = {
                                Icon(Icons.Default.Delete, contentDescription = "")
                            },
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(end = 16.dp),
                            onClick = {
                                itemClicked(task)
                            }
                        )
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        val navController = rememberNavController()
        Scaffold(modifier = Modifier.fillMaxSize(), {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "ToDo Performance") }
            )
        }, floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("taskScreen")
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Task"
                )
            }

        }) { innerPadding ->

            ItemsList(
                listOf(
                    TaskModel(1, "Task 1", "Description for Task 1", false),
                    TaskModel(2, "Task 2", "Description for Task 2", true),
                    TaskModel(3, "Task 3", "Description for Task 3", false),
                ),
                navController = navController
            ) {

            }

        }
    }

}