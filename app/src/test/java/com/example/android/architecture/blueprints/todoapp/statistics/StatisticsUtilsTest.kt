package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    // If there is 0 completed task and 1 active task
    // then there are 100% active tasks and 0% completed tasks

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // GIVEN a list of tasks with a single, active, task (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 0% completed tasks and 100% active tasks
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    // If there is 2 completed task and 3 active task
    // then there are 60% active tasks and 40% completed tasks

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        // GIVEN a list of tasks with 2, completed, task (the true makes this completed)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )
        // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 40% completed tasks and 60% active tasks
        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    // If List of task is empty
    // then there are 0% active tasks and 0% completed tasks

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        // GIVEN an empty list of tasks
        val tasks = emptyList<Task>()

        // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 0% completed tasks and 0% active tasks
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    // If List of task is null
    // then there are 0% active tasks and 0% completed tasks

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // GIVEN a null list of tasks
        val tasks = null

        // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // // THEN there are 0% completed tasks and 0% active tasks
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

}