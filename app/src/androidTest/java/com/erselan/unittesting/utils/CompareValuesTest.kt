package com.erselan.unittesting.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import com.erselan.unittesting.R
import org.junit.After
import org.junit.Before
import org.junit.Test

class CompareValuesTest {

    private lateinit var compareValues: CompareValues

    /*
    initialize compareValues separately for every single test case
    */
    @Before
    fun setUp() {
        compareValues = CompareValues()
    }

    /*
    return true when strings are same
    */
    @Test
    fun checkStringsAreSame_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val value = compareValues.comparesStrings(context, R.string.enter_email, "Enter Email")
        assertThat(value).isTrue()
    }

    /*
    return false when strings are different
    */
    @Test
    fun checkStringsAreDifferent_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val value = compareValues.comparesStrings(context, R.string.enter_email, "Erselan Khan")
        assertThat(value).isFalse()
    }

    @After
    fun teardown() {
        // do something like closing database after every test case
    }

}