/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import org.junit.Test
import kotlin.test.assertFailsWith

class BooleanExpectationTests {
    @Test
    fun toBeTrueTest() {
        expect(true).toBeTrue()

        assertFailsWith(AssertionError::class) {
            expect(false).toBeTrue()
        }

        true.should.beTrue()

        assertFailsWith(AssertionError::class) {
            false.should.beTrue()
        }
    }

    @Test
    fun toBeFalseTest() {
        expect(false).toBeFalse()

        assertFailsWith(AssertionError::class) {
            expect(true).toBeFalse()
        }

        false.should.beFalse()

        assertFailsWith(AssertionError::class) {
            true.should.beFalse()
        }
    }
}