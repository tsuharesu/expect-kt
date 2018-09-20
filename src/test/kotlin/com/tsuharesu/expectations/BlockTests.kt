/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import org.junit.Test
import kotlin.test.assertFailsWith

class BlockTests {
    @Test
    fun expectBlock() {
        expect("james") {
            toStartWith("j")
            toEndWith("s")
        }

        assertFailsWith(AssertionError::class) {
            expect("james") {
                toStartWith("j")
                toEndWith("f")
            }
        }.message.should.be("james expected to end with f")

        assertFailsWith(AssertionError::class) {
            expect("james") {
                toStartWith("f")
                toEndWith("s")
            }
        }.message.should.be("james expected to start with f")
    }

    @Test
    fun shouldBlock() {
        "james".should {
            startWith("j")
            endWith("s")
        }
        assertFailsWith(AssertionError::class) {
            "james".should {
                startWith("j")
                endWith("f")
            }
        }.message.should.be("james expected to end with f")

        assertFailsWith(AssertionError::class) {
            "james".should {
                startWith("f")
                endWith("s")
            }
        }.message.should.be("james expected to start with f")
    }
}