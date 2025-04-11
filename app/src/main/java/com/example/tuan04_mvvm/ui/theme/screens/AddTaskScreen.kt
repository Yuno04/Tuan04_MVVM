package com.example.tuan04_mvvm.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuan04_mvvm.viewmodel.TaskViewModel

@Composable
fun AddTaskScreen(
    navController: NavController,
    viewModel: TaskViewModel
) {
    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        // Thêm không gian trống ở trên để tránh bị che bởi viền điện thoại
        Spacer(modifier = Modifier.height(40.dp))

        // TopAppBar tùy chỉnh thay vì sử dụng TopAppBar của Material
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }

            Text(
                text = "Add New",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Nội dung chính
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Task",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            OutlinedTextField(
                value = taskTitle,
                onValueChange = { taskTitle = it },
                placeholder = { Text("Do homework") },
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Description",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            OutlinedTextField(
                value = taskDescription,
                onValueChange = { taskDescription = it },
                placeholder = { Text("Don't give up") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (taskTitle.isNotEmpty()) {
                        viewModel.addTask(taskTitle, taskDescription)
                        navController.navigateUp()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF2196F3),
                    contentColor = Color.White
                )
            ) {
                Text("Add")
            }
        }
    }
}