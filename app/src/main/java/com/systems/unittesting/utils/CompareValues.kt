package com.systems.unittesting.utils

import android.content.Context

class CompareValues {

    fun comparesStrings(context: Context, resId: Int, value: String): Boolean {
        return context.getString(resId) == value
    }
}