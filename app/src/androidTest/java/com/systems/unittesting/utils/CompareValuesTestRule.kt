package com.systems.unittesting.utils

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class CompareValuesTestRule(var compareValuesTest: CompareValuesTest) : TestRule {

    override fun apply(base: Statement, description: Description?): Statement {
        return CustomStatement(base, compareValuesTest)
    }

    class CustomStatement(private val base: Statement, private var compareValuesTest: CompareValuesTest) : Statement() {
        @Throws(Throwable::class)
        override fun evaluate() {
            // Add something you do before
            compareValuesTest.compareValues = CompareValues()
            try {
                base.evaluate() // This executes your tests
            } finally {
                // Add something you do after test
                compareValuesTest.compareValues = null
            }
        }

    }
}