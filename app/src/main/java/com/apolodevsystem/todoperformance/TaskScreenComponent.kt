package com.apolodevsystem.todoperformance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.apolodevsystem.todoperformance.ui.theme.ToDoPerformanceTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TaskScreenComponent(navController: NavController) {
    ToDoPerformanceTheme {

        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var isCompleted by remember { mutableStateOf(false) }

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.fillMaxSize().padding(innerPadding)) {
                Text("Create Task")

                TextField(value = title, onValueChange = {
                    title = it
                }, label = { Text("Title") })

                TextField(value = description, onValueChange = {
                    description = it
                }, label = { Text("Description") })

                Row(Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(isCompleted, onCheckedChange = {
                        isCompleted = it
                    })
                    Text("Concluída")
                }

                Button({
                    navController.popBackStack()
                }) {
                    Text("Salvar")
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskScreenComponentPreview() {
    val navController = rememberNavController()
    TaskScreenComponent(navController)
}