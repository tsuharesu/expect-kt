/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package com.tsuharesu.expectations.tests

import com.tsuharesu.expectations.expect
import com.tsuharesu.expectations.should
import org.junit.Test
import kotlin.test.assertFailsWith

class GenericExpectationTests {
    @Test
    fun toBe() {
        expect("james").toBe("james")

        assertFailsWith(AssertionError::class, {
            expect("pass").toBe("fail")
        }).message.should.be("expected <pass> to be <fail>")

        "james".should.be("james")

        assertFailsWith(AssertionError::class, {
            "pass".should.be("fail")
        })
    }

    @Test
    fun toNotBe() {
        expect("james").toNotBe("fail")

        assertFailsWith(AssertionError::class, {
            expect("fail").toNotBe("fail")
        })

        "james".should.notBe("fail")

        assertFailsWith(AssertionError::class, {
            "fail".should.notBe("fail")
        })
    }

    @Test
    fun toBeNull() {
        expect(null).toBeNull()

        assertFailsWith(AssertionError::class, {
            expect("pass").toBeNull()
        })

        val x: Int? = null
        x.should.beNull()

        assertFailsWith(AssertionError::class, {
            "pass".should.beNull()
        })
    }

    @Test
    fun toNotBeNull() {
        expect("asdasd").toNotBeNull()

        assertFailsWith(AssertionError::class, {
            expect(null).toNotBeNull()
        })

        "asdasd".should.notBeNull()

        assertFailsWith(AssertionError::class, {
            val x: Int? = null
            x.should.notBeNull()
        })
    }
}