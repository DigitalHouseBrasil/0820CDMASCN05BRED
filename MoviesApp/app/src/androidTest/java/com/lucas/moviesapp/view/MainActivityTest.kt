package com.lucas.moviesapp.view

import androidx.test.rule.ActivityTestRule
import com.lucas.moviesapp.robot.MainRobot
import com.lucas.moviesapp.service.MovieService
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    private lateinit var robot: MainRobot
    private var mockWebServer: MockWebServer? = null

    init {
        mockWebServer = MockWebServer()
        MovieService.setBaseUrl(mockWebServer?.url("/").toString())
    }

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        robot = MainRobot(activityRule)
    }

    @Test
    fun testInputType(){
        robot
            .startActivity()
            .inputType()
    }

    @Test
    fun testClickButton(){
        robot.startActivity()
            .clickButton()
    }

    @Test
    fun testInputTypeAndClickButton(){
        robot.startActivity()
            .inputType()
            .clickButton()
    }

    @After
    fun tearDown() {
        mockWebServer?.shutdown()
        robot.finishActivity()

    }
}