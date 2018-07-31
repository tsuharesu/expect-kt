/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import org.junit.Test
import kotlin.test.assertFailsWith

class GenericExpectationTests {
    @Test
    fun toBe() {
        expect("james").toBe("james")

        assertFailsWith(AssertionError::class) {
            expect("pass").toBe("fail")
        }.message.should.be("expected <pass> to be <fail>")

        "james".should.be("james")

        assertFailsWith(AssertionError::class) {
            "pass".should.be("fail")
        }
    }

    class SomeTestClass

    @Test
    fun toBeInstanceOf() {
        expect("james").toBeInstanceOf(String::class)
        expect(SomeTestClass()).toBeInstanceOf(SomeTestClass::class)

        "james".should.beInstanceOf(String::class)
    }

    @Test
    fun toNotBe() {
        expect("james").toNotBe("fail")

        assertFailsWith(AssertionError::class) {
            expect("fail").toNotBe("fail")
        }

        "james".should.notBe("fail")

        assertFailsWith(AssertionError::class) {
            "fail".should.notBe("fail")
        }
    }

    @Test
    fun toBeNull() {
        expect(null).toBeNull()

        assertFailsWith(AssertionError::class) {
            expect("pass").toBeNull()
        }

        val x: Int? = null
        x.should.beNull()

        assertFailsWith(AssertionError::class) {
            "pass".should.beNull()
        }
    }

    @Test
    fun toNotBeNull() {
        expect("asdasd").toNotBeNull()

        assertFailsWith(AssertionError::class) {
            expect(null).toNotBeNull()
        }

        "asdasd".should.notBeNull()

        assertFailsWith(AssertionError::class) {
            val x: Int? = null
            x.should.notBeNull()
        }
    }
}