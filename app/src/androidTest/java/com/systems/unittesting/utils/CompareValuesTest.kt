package com.systems.unittesting.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import com.systems.unittesting.R
import org.junit.Rule
import org.junit.Test

class CompareValuesTest {

    /*@Rule @JvmField
    val compareValuesTestRule = CompareValuesTestRule(this)*/

    @get:Rule
    val compareValuesTestRule = CompareValuesTestRule(this)

    var compareValues: CompareValues? = null

    /*
    returns true when strings are same
    */
    @Test
    fun checkStringsAreSame_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Here we are using the compareValues object
        // which we already initialized on our CompareValuesTestRule class before each test case
        val value = compareValues?.comparesStrings(context, R.string.enter_email, "Enter Email")
        assertThat(value).isTrue()
    }

    /*
    returns false when strings are different
    */
    @Test
    fun checkStringsAreDifferent_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Here we are using the compareValues object
        // which we already initialized on our CompareValuesTestRule class before each test case
        val value = compareValues?.comparesStrings(context, R.string.enter_email, "Erselan Khan")
        assertThat(value).isFalse()
    }
}