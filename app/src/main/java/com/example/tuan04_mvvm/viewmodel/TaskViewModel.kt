package com.example.tuan04_mvvm.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.tuan04_mvvm.model.Task

class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateOf<List<Task>>(listOf())
    val tasks: State<List<Task>> = _tasks

    init {
        // Add some sample tasks
        addSampleTasks()
    }

    private fun addSampleTasks() {
        val sampleTasks = listOf(
            Task(
                title = "Complete Android Project",
                description = "Finish the UI, integrate API, and write documentation",
                color = Color(0xFFADD8E6) // Light blue
            ),
            Task(
                title = "Complete Android Project",
                description = "Finish the UI, integrate API, and write documentation",
                color = Color(0xFFF8C8DC) // Light pink
            ),
            Task(
                title = "Complete Android Project",
                description = "Finish the UI, integrate API, and write documentation",
                color = Color(0xFFF0E68C) // Light yellow
            ),
            Task(
                title = "Complete Android Project",
                description = "Finish the UI, integrate API, and write documentation",
                color = Color(0xFFF8C8DC) // Light pink
            )
        )

        _tasks.value = sampleTasks
    }

    fun addTask(title: String, description: String) {
        val colors = listOf(
            Color(0xFFADD8E6), // Light blue
            Color(0xFFF8C8DC), // Light pink
            Color(0xFFF0E68C), // Light yellow
            Color(0xFFF8C8DC)  // Light pink
        )

        val newTask = Task(
            title = title,
            description = description,
            color = colors.random()
        )

        _tasks.value = _tasks.value + newTask
    }
}