/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package com.tsuharesu.expectations.tests

import com.tsuharesu.expectations.*
import kotlin.test.assertFailsWith
import org.junit.Test as test


class GenericExpectationTests {
    @org.junit.Test fun toBe() {
        expect("james").toBe("james")

        assertFailsWith(AssertionError::class, {
            expect("pass").toBe("fail")
        }).message.should.be("expected <pass> to be <fail>")

        "james".should.be("james")

        assertFailsWith(AssertionError::class, {
            "pass".should.be("fail")
        })
    }

    @org.junit.Test fun toNotBe() {
        expect("james").toNotBe("fail")

        assertFailsWith(AssertionError::class, {
            expect("fail").toNotBe("fail")
        })

        "james".should.notBe("fail")

        assertFailsWith(AssertionError::class, {
            "fail".should.notBe("fail")
        })
    }

    @org.junit.Test fun toBeNull() {
        expect(null).toBeNull()

        assertFailsWith(AssertionError::class, {
            expect("pass").toBeNull()
        })

        var x: Int? = null
        x.should.beNull()

        assertFailsWith(AssertionError::class, {
            "pass".should.beNull()
        })
    }

    @org.junit.Test fun toNotBeNull() {
        expect("asdasd").toNotBeNull()

        assertFailsWith(AssertionError::class, {
            expect(null).toNotBeNull()
        })

        "asdasd".should.notBeNull()

        assertFailsWith(AssertionError::class, {
            var x: Int? = null
            x.should.notBeNull()
        })
    }
}