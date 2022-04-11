package com.example.lightspeedtest.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.example.lightspeedtest.R
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import java.util.*

class PhotoActivityTest {
    @get: Rule
    val activityRule = ActivityTestRule(PhotoActivity::class.java)

    @Test
    fun isActivityInView() {
        onView(withId(R.id.photoView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    @Throws(InterruptedException::class)
    fun testVisibilityRecyclerView() {
        Thread.sleep(1000)
        onView(withId(R.id.recyclerview))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    @Throws(InterruptedException::class)
    fun testCaseForRecyclerScroll() {
        Thread.sleep(1000)
        val recyclerView = activityRule.activity.findViewById<RecyclerView>(R.id.recyclerview)
        val itemCount = Objects.requireNonNull(recyclerView.adapter!!).itemCount
        onView(withId(R.id.recyclerview))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
            .perform(scrollToPosition<RecyclerView.ViewHolder>(itemCount - 1))
    }
}