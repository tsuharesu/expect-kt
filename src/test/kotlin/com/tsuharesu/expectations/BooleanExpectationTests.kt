/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Tsuharesu
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
        }.message.should.be("false expected to be true")

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
        }.message.should.be("true expected to be false")

        false.should.beFalse()

        assertFailsWith(AssertionError::class) {
            true.should.beFalse()
        }
    }
}