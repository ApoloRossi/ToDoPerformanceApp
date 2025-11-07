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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import com.apolodevsystem.todoperformance.states.TasksState
import com.apolodevsystem.todoperformance.ui.theme.ToDoPerformanceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksListScreenComponent(navController: NavController, taskViewModel: TaskViewModel) {
    ToDoPerformanceTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "ToDo Performance") }
            )
        }, floatingActionButton = {
            FloatingActionButton (onClick = {
                navController.navigate("taskScreen")
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
                        modifier = Modifier.padding(innerPadding)
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
    itemClicked: (TaskModel) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)) {
        tasks.forEach {
            item {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            Log.d("TAG", "ItemsList: ${it.title}")
                        }
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("${it.title}")
                        Text("${it.description}")
                        Text("Completed: ${it.isCompleted}")
                    }

                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = {
                            itemClicked(it)
                        }) {
                        Text("Remover")
                    }
                }
                HorizontalDivider(thickness = 2.dp)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
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
        FloatingActionButton (onClick = {
            navController.navigate("taskScreen")
        }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Task"
            )
        }

    }) { innerPadding ->
        ToDoPerformanceTheme {
            ItemsList(
                listOf(
                    TaskModel("Task 1", "Description for Task 1", false),
                    TaskModel("Task 2", "Description for Task 2", true),
                    TaskModel("Task 3", "Description for Task 3", false),
                )
            ) {

            }
        }
    }

}