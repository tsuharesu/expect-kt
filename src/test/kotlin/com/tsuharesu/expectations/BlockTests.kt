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
        }

        assertFailsWith(AssertionError::class) {
            expect("james") {
                toStartWith("f")
                toEndWith("s")
            }
        }
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
        }

        assertFailsWith(AssertionError::class) {
            "james".should {
                startWith("f")
                endWith("s")
            }
        }
    }
}