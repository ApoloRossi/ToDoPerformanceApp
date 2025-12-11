package com.apolodevsystem.todoperformance

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
fun TasksListScreenComponent(navController: NavController,
                             taskViewModel: TaskViewModel) {
    AppTheme {

        var showBottomSheet by remember { mutableStateOf(false) }
        val sheetState = rememberModalBottomSheetState()
        var taskId = 0

        Scaffold(modifier = Modifier.fillMaxSize(), topBar =  {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "ToDo Performance") }
            )
        }, floatingActionButton = {
            FloatingActionButton(onClick = {
                showBottomSheet = true
                taskId = 0
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
                        navController = navController,
                        removeItemClicked = { taskViewModel.removeTask(it)}
                    ) { task ->
                        taskId = task
                        showBottomSheet = true
                    }
                }
            }

            if(showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    TaskScreenComponent(taskId, taskViewModel) {
                        showBottomSheet = false
                        taskId = 0
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
    removeItemClicked: (TaskModel) -> Unit,
    onItemClicked: (Int) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.primaryContainer), contentPadding = PaddingValues(8.dp)) {
        tasks.forEach { task ->
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                onItemClicked(task.id)
                            }
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(task.title, style = MaterialTheme.typography.titleMedium)
                            Spacer(Modifier.padding(4.dp))
                            Text(task.description, style = MaterialTheme.typography.bodyMedium, maxLines = 2)
                        }

                        Checkbox(
                            modifier = Modifier.weight(0.5f)
                                .align(Alignment.CenterVertically).height(8.dp),
                            checked = task.isCompleted,
                            onCheckedChange = {

                            }
                        )

                        IconButton(
                            content = {
                                Icon(Icons.Default.Delete, contentDescription = "")
                            },
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(end = 16.dp),
                            onClick = {
                                removeItemClicked(task)
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
            innerPadding.calculateTopPadding()
            ItemsList(
                listOf(
                    TaskModel(1, "Task 1", "Description for Task 1, Description for Task 1,Description for Task 1, Description for Task 1", false),
                    TaskModel(2, "Task 2", "Description for Task 1, Description for Task 1,Description for Task 1, Description for Task 1", true),
                    TaskModel(3, "Task 3", "Description for Task 3", false),
                ),
                navController = navController,
                onItemClicked = {},
                removeItemClicked = {}
            )

        }
    }

}