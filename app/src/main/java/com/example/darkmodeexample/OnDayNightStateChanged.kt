package com.example.darkmodeexample

/**
 * @author at-vinhnguyen on 2/2/21.
 */
interface OnDayNightStateChanged {
    fun onDayNightApplied(state: Int)

    companion object {
        const val DAY = 1
        const val NIGHT = 2
    }
}
