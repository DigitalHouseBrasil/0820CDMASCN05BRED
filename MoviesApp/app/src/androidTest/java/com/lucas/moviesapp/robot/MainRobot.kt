package com.lucas.moviesapp.robot

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.lucas.moviesapp.R
import com.lucas.moviesapp.utils.MainUtils
import com.lucas.moviesapp.view.MainActivity

class MainRobot(
    private val activityTestRule: ActivityTestRule<MainActivity>
) {

    fun startActivity(): MainRobot {
        activityTestRule.launchActivity(Intent(Intent.ACTION_MAIN))
        return this
    }

    fun finishActivity() {
        activityTestRule.finishActivity()
    }

    fun inputType(): MainRobot{
        MainUtils.inputType(R.id.etName, "Lucas")
        MainUtils.hideKeyboard()
        MainUtils.inputType(R.id.etProfissao, "Dev Android")
        MainUtils.hideKeyboard()
        return this
    }

    fun clickButton(): MainRobot {
        MainUtils.clickButton(R.id.btnEntrar)
        return this
    }
}