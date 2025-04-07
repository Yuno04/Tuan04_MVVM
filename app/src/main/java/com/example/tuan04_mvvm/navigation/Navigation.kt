package com.example.tuan04_mvvm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tuan04_mvvm.ui.theme.screens.AddTaskScreen
import com.example.tuan04_mvvm.ui.theme.screens.TaskListScreen
import com.example.tuan04_mvvm.viewmodel.TaskViewModel

@Composable
fun SetupNavigation(navController: NavHostController) {
    val viewModel: TaskViewModel = viewModel()

    NavHost(navController = navController, startDestination = "taskList") {
        composable("taskList") {
            TaskListScreen(navController = navController, viewModel = viewModel)
        }
        composable("addTask") {
            AddTaskScreen(navController = navController, viewModel = viewModel)
        }
    }
}