/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Tsuharesu
 */

package com.tsuharesu.expectations

import org.junit.Test
import kotlin.test.assertFailsWith

class ChainingTests {
    @Test
    fun and() {
        expect("james").toStartWith("j").and.toEndWith("s")

        assertFailsWith(AssertionError::class) {
            expect("james").toStartWith("j").and.toEndWith("f")
        }.message.should.be("james expected to end with f")

        assertFailsWith(AssertionError::class) {
            expect("james").toStartWith("f").and.toEndWith("s")
        }.message.should.be("james expected to start with f")
    }

    @Test
    fun shouldAnd() {
        "james".should.startWith("j").and.endWith("s")

        assertFailsWith(AssertionError::class) {
            "james".should.startWith("j").and.endWith("f")
        }.message.should.be("james expected to end with f")

        assertFailsWith(AssertionError::class) {
            "james".should.startWith("f").and.endWith("s")
        }.message.should.be("james expected to start with f")
    }
}