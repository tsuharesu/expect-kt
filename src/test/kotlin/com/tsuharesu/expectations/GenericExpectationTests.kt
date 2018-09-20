/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Tsuharesu
 */

package com.tsuharesu.expectations

import org.junit.Test
import kotlin.test.assertFailsWith

private class SomeTestClass

class GenericExpectationTests {
    @Test
    fun toBe() {
        expect("james").toBe("james")

        assertFailsWith(AssertionError::class) {
            expect("pass").toBe("fail")
        }.message.should.be("pass expected to be fail")

        "james".should.be("james")

        assertFailsWith(AssertionError::class) {
            "pass".should.be("fail")
        }.message.should.be("pass expected to be fail")
    }

    @Test
    fun toBeInstanceOf() {
        expect("james").toBeInstanceOf(String::class)
        expect(SomeTestClass()).toBeInstanceOf(SomeTestClass::class)

        assertFailsWith(AssertionError::class) {
            expect(1).toBeInstanceOf(String::class)
        }.message.should.be("1 expected to be instance of String")

        "james".should.beInstanceOf(String::class)
        assertFailsWith(AssertionError::class) {
            "james".should.beInstanceOf(Int::class)
        }.message.should.be("james expected to be instance of int")
    }

    @Test
    fun toNotBe() {
        expect("james").toNotBe("fail")

        assertFailsWith(AssertionError::class) {
            expect("fail").toNotBe("fail")
        }.message.should.be("fail expected to not be fail")

        "james".should.notBe("fail")

        assertFailsWith(AssertionError::class) {
            "fail".should.notBe("fail")
        }.message.should.be("fail expected to not be fail")
    }

    @Test
    fun toBeNull() {
        expect(null).toBeNull()

        assertFailsWith(AssertionError::class) {
            expect("pass").toBeNull()
        }.message.should.be("pass expected to be null")

        val x: Int? = null
        x.should.beNull()

        assertFailsWith(AssertionError::class) {
            "pass".should.beNull()
        }.message.should.be("pass expected to be null")
    }

    @Test
    fun toNotBeNull() {
        expect("asdasd").toNotBeNull()

        assertFailsWith(AssertionError::class) {
            expect(null).toNotBeNull()
        }.message.should.be("expected to not be null")

        "asdasd".should.notBeNull()

        assertFailsWith(AssertionError::class) {
            val x: Int? = null
            x.should.notBeNull()
        }.message.should.be("expected to not be null")
    }
}