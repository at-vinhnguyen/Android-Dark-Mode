package com.example.darkmodeexample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_darkmode.*

/**
 * @author at-vinhnguyen on 2/2/21.
 */
class DarkModeFragment : Fragment(), OnDayNightStateChanged {

    companion object {
        fun newInstance() = DarkModeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_darkmode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        switchCompatDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }

    override fun onDayNightApplied(state: Int) {
        if (state == OnDayNightStateChanged.DAY) {
            llDarkMode.setBackgroundColor(Color.WHITE)
        } else {
            llDarkMode.setBackgroundColor(Color.BLACK)
        }
    }
}
