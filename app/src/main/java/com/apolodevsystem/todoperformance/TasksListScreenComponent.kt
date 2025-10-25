package com.apolodevsystem.todoperformance

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.apolodevsystem.todoperformance.ui.theme.ToDoPerformanceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksListScreenComponent(navController: NavController) {
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
            ItemsList(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun ItemsList(name: String, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(1000) { index ->
            Text("Message $index")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoPerformanceTheme {
        ItemsList("Android")
    }
}