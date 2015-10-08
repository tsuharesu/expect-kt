/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations.tests

import kotlin.expectations.expect
import kotlin.expectations.should
import kotlin.test.assertFailsWith
import org.junit.Test as test


class GenericExpectationTests {
    @test fun toBe() {
        expect("james").toBe("james")

        assertFailsWith(AssertionError::class.java, {
            expect("pass").toBe("fail")
        }).getMessage()?.should?.be("expected <pass> to be <fail>")

        "james".should.be("james")

        assertFailsWith(AssertionError::class.java, {
            "pass".should.be("fail")
        })
    }

    @test fun toNotBe() {
        expect("james").toNotBe("fail")

        assertFailsWith(AssertionError::class.java, {
            expect("fail").toNotBe("fail")
        })

        "james".should.notBe("fail")

        assertFailsWith(AssertionError::class.java, {
            "fail".should.notBe("fail")
        })
    }

    @test fun toBeNull() {
        expect(null).toBeNull()

        assertFailsWith(AssertionError::class.java, {
            expect("pass").toBeNull()
        })

        null.should.beNull()

        assertFailsWith(AssertionError::class.java, {
            "pass".should.beNull()
        })
    }

    @test fun toNotBeNull() {
        expect("asdasd").toNotBeNull()

        assertFailsWith(AssertionError::class.java, {
            expect(null).toNotBeNull()
        })

        "asdasd".should.notBeNull()

        assertFailsWith(AssertionError::class.java, {
            null.should.notBeNull()
        })
    }
}