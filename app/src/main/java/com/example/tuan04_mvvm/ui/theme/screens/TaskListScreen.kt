package com.example.tuan04_mvvm.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuan04_mvvm.ui.theme.components.TaskItem
import com.example.tuan04_mvvm.viewmodel.TaskViewModel


@Composable
fun TaskListScreen(
    navController: NavController,
    viewModel: TaskViewModel
) {
    val tasks = viewModel.tasks.value

    Column(modifier = Modifier.fillMaxSize()) {
        // Thêm không gian trống ở trên để tránh bị che bởi viền điện thoại
        Spacer(modifier = Modifier.height(40.dp))

        // TopAppBar tùy chỉnh thay vì sử dụng TopAppBar của Material
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { /* Xử lý khi nhấn nút back */ },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }

                Text(
                    text = "List",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            IconButton(
                onClick = { /* Xử lý khi nhấn nút add ở thanh tiêu đề */ },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.Red
                )
            }
        }

        // Danh sách task
        Box(modifier = Modifier.weight(1f)) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(tasks) { task ->
                    TaskItem(task = task)
                }
            }
        }

        // Bottom navigation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.White)
                .padding(bottom = 20.dp), // <-- Thêm dòng này ,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Calendar"
                )
            }
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                FloatingActionButton(
                    onClick = { navController.navigate("addTask") },
                    backgroundColor = Color(0xFF2196F3)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Task",
                        tint = Color.White
                    )
                }
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "Documents"
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
        }
    }
}