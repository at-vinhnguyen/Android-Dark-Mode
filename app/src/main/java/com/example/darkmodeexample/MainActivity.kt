package com.example.darkmodeexample

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * @author at-vinhnguyen on 2/2/21.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frmContainer, DarkModeFragment.newInstance(), "").commit()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val nightModeFlag = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        applyDayNight(if (nightModeFlag == Configuration.UI_MODE_NIGHT_NO) OnDayNightStateChanged.DAY else OnDayNightStateChanged.NIGHT)
    }

    private fun applyDayNight(state: Int) {
        supportFragmentManager.fragments.forEach {
            (it as? DarkModeFragment)?.onDayNightApplied(state)
        }
    }
}
