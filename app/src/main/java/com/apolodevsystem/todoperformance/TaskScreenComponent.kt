package com.apolodevsystem.todoperformance

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.apolodevsystem.todoperformance.ui.theme.AppTheme

@Composable
fun TaskScreenComponent(
    taskId: Int,
    taskViewModel: TaskViewModel,
    onSave: () -> Unit
) {
    AppTheme {

        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var isCompleted by remember { mutableStateOf(false) }

        var taskState: TaskModel? = null

        if (taskId > 0) {
            val taskFlowState = taskViewModel.taskFlow.collectAsStateWithLifecycle()
            taskState = taskFlowState.value
        }

        LaunchedEffect(taskId) {
            if (taskId > 0) {
                taskViewModel.getTaskById(taskId)
            }
        }

        LaunchedEffect(taskState) {
            if (taskState != null) {
                title = taskState.title
                description = taskState.description
                isCompleted = taskState.isCompleted
            } else {
                title = ""
                description = ""
                isCompleted = false
            }
        }

        Scaffold(modifier = Modifier.fillMaxSize().padding(16.dp)) { innerPadding ->
            Column(Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
                Text("Create Task", fontSize = 32.sp)

                Spacer(Modifier.padding(4.dp))

                TextField(modifier = Modifier.fillMaxWidth(), value = title, onValueChange = {
                    title = it
                }, label = { Text("Título") })

                Spacer(Modifier.padding(4.dp))

                TextField(modifier = Modifier.fillMaxWidth(), value = description, onValueChange = {
                    description = it
                }, label = { Text("Descrição") })

                Spacer(Modifier.padding(4.dp))

                Row(Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Switch(
                        checked = isCompleted,
                        onCheckedChange = {
                            isCompleted = it
                        }
                    )

                    Text(modifier = Modifier.padding(8.dp), text = "Concluída")
                }
                Spacer(Modifier.padding(4.dp))
                Button(modifier = Modifier.fillMaxWidth(), onClick = {

                    taskViewModel.addTask(
                        TaskModel(
                            taskId,
                            title,
                            description,
                            isCompleted
                        )
                    )
                    onSave()
                }) {
                    Text("Salvar")
                }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
fun TaskScreenComponentPreview() {
    val taskViewModel = TaskViewModel()
    TaskScreenComponent(1, taskViewModel) {

    }
}