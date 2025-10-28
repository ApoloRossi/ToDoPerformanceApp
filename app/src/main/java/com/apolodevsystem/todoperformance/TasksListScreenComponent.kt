package com.apolodevsystem.todoperformance

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
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
            Button(onClick = {
                navController.navigate("taskScreen")
            }) {
                Text("Add Task")
            }

        }) { innerPadding ->
            val state = taskViewModel.tasksFlow.collectAsStateWithLifecycle().value
            when (state) {
                is TasksState.Loading -> {
                    // You can show a loading indicator here if needed
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
                    )
                }
            }
        }
    }
}

@Composable
fun ItemsList(tasks: List<TaskModel>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)) {
        tasks.forEach {
            item {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            Log.d("TAG", "ItemsList: ${it.title}")
                        }
                ) {
                    Text("${it.title}")
                    Text("${it.description}")
                    Text("Completed: ${it.isCompleted}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoPerformanceTheme {
        ItemsList(listOf())
    }
}