package com.lucas.moviesapp.utils

import android.app.Activity
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*

object MainUtils {

    fun scroll(recyclerId: Int, pos: Int) {
        onView(withId(recyclerId))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(pos))
    }

    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatchers {
        return RecyclerViewMatchers(recyclerViewId)
    }

    fun checkTextIsDisplayedOnRecyclerViewPosition(id: Int, position: Int, text: String) {
        onView(withRecyclerView(id).atPosition(position))
            .check(matches(hasDescendant(withText(text))))
    }

    fun checkRecyclerView(recyclerViewId: Int) {
        onView(withId(recyclerViewId))
            .check(matches(isDisplayed()))
    }

    fun inputType(id: Int, text: String) {
        onView(withId(id))
            .perform(typeText(text))
    }

    fun hideKeyboard() {
        closeSoftKeyboard()
    }

    fun clickButton(id: Int) {
        onView(withId(id))
            .perform(click())
    }

    fun scrollToRecyclerViewLastPosition(
        activity: Activity,
        @IdRes recyclerViewId: Int
    ) {
        val recyclerView = activity.findViewById<RecyclerView>(recyclerViewId)
        val itemCount = recyclerView.adapter?.itemCount as Int
        onView(withId(recyclerViewId))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(itemCount - 1))
    }

}