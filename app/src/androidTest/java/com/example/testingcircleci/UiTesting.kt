package com.example.testingcircleci

import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiTesting {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)
    @Test
    fun `when_fun_set_text_runs_and_assigned_to_TextView_should_display_the_Same_text`(){
        val testTextView = activityRule.activity.findViewById<TextView>(R.id.test_text)
        runBlocking {
            delay(1000)
            val job: Job = launch(Main){
                testTextView.text = MainViewModel().setTextView()
            }
        }
        onView(withText("Pedrito Bebe")).check(matches(isDisplayed()))
    }
}