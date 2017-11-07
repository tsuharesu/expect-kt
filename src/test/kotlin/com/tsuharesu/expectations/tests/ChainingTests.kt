/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations.tests

import com.tsuharesu.expectations.* // ktlint-disable no-wildcard-imports
import org.junit.Test
import kotlin.test.assertFailsWith

class ChainingTests {
    @Test
    fun and() {
        expect("james").toStartWith("j").and.toEndWith("s")

        assertFailsWith(AssertionError::class, {
            expect("james").toStartWith("j").and.toEndWith("f")
        })

        assertFailsWith(AssertionError::class, {
            expect("james").toStartWith("f").and.toEndWith("s")
        })
    }

    @org.junit.Test
    fun shouldAnd() {
        "james".should.startWith("j").and.endWith("s")

        assertFailsWith(AssertionError::class, {
            "james".should.startWith("j").and.endWith("f")
        })

        assertFailsWith(AssertionError::class, {
            "james".should.startWith("f").and.endWith("s")
        })
    }
}