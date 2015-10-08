/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations.tests

import kotlin.expectations.*
import kotlin.test.assertFailsWith
import org.junit.Test as test


class StringExpectationTests {

    @test fun toBeEmpty() {

        expect("").toBeEmpty()

        assertFailsWith(AssertionError::class.java, {
            expect("james").toBeEmpty()
        })

        assertFailsWith(AssertionError::class.java, {
            expect("     ").toBeEmpty()
        })

        "".should.beEmpty()

        assertFailsWith(AssertionError::class.java, {
            "pass".should.beEmpty()
        })
    }

    @test fun toNotBeEmpty() {

        expect("james").toNotBeEmpty()

        assertFailsWith(AssertionError::class.java, {
            expect("").toNotBeEmpty()
        })

        expect("     ").toNotBeEmpty()

        "james".should.notBeEmpty()

        assertFailsWith(AssertionError::class.java, {
            "".should.notBeEmpty()
        })
    }

    @test fun toHaveLengthOf() {
        expect("james").toHaveLengthOf(5)

        assertFailsWith(AssertionError::class.java, {
            expect("james").toHaveLengthOf(12)
        })

        "james".should.haveLengthOf(5)

        assertFailsWith(AssertionError::class.java, {
            "james".should.haveLengthOf(12)
        })
    }

    @test fun toBeBlank() {
        expect("").toBeBlank()
        expect("   ").toBeBlank()

        "".should.beBlank()
        "    ".should.beBlank()

        assertFailsWith(AssertionError::class.java, {
            expect("james").toBeBlank()
        })

        assertFailsWith(AssertionError::class.java, {
            "james".should.beBlank()
        })
    }

    @test fun toNotBeBlank() {
        expect("james").toNotBeBlank()
        expect("  james ").toNotBeBlank()

        "james".should.notBeBlank()
        "   james ".should.notBeBlank()

        assertFailsWith(AssertionError::class.java, {
            expect("").toNotBeBlank()
        })

        assertFailsWith(AssertionError::class.java, {
            expect("     ").toNotBeBlank()
        })

        assertFailsWith(AssertionError::class.java, {
            "".should.notBeBlank()
        })

        assertFailsWith(AssertionError::class.java, {
            "    ".should.notBeBlank()
        })
    }

    @test fun toEndWith() {
        expect("james").toEndWith("s")

        assertFailsWith(AssertionError::class.java, {
            expect("james").toEndWith("j")
        })

        "james".should.endWith("s")

        assertFailsWith(AssertionError::class.java, {
            "james".should.endWith("j")
        })
    }

    @test fun toContain() {
        expect("james").toContain("ame")

        assertFailsWith(AssertionError::class.java, {
            expect("james").toContain("nope")
        })

        "james".should.contain("ame")

        assertFailsWith(AssertionError::class.java, {
            "james".should.contain("nope")
        })
    }

    @test fun toNotContain() {
        expect("james").toNotContain("nope")

        assertFailsWith(AssertionError::class.java, {
            expect("james").toNotContain("ame")
        })

        "james".should.notContain("nope")

        assertFailsWith(AssertionError::class.java, {
            "james".should.notContain("ame")
        })
    }

    @test fun toStartWith() {
        expect("james").toStartWith("j")

        assertFailsWith(AssertionError::class.java, {
            expect("james").toStartWith("s")
        })

        "james".should.startWith("j")

        assertFailsWith(AssertionError::class.java, {
            "james".should.startWith("s")
        })
    }

    @test fun toMatch() {
        expect("james").toMatch("^james$")

        assertFailsWith(AssertionError::class.java, {
            expect("james").toMatch("^fail$")
        })

        "james".should.match("^james$")

        assertFailsWith(AssertionError::class.java, {
            "james".should.match("^fail$")
        })
    }

    @test fun toEndWithEquivalent() {
        expect("james").toEndWithEquivalent("S")

        "james".should.endWithEquivalent("S")
    }

    @test fun toContainEquivalent() {
        expect("james").toContainEquivalent("aMe")

        "james".should.containEquivalent("aMe")
    }

    @test fun toNotContainEquivalent() {
        assertFailsWith(AssertionError::class.java, {
            expect("james").toNotContainEquivalent("aMe")
        })

        assertFailsWith(AssertionError::class.java, {
            "james".should.notContainEquivalent("aMe")
        })
    }

    @test fun toStartWithEquivalent() {
        expect("james").toStartWithEquivalent("J")

        "james".should.startWithEquivalent("J")
    }
}