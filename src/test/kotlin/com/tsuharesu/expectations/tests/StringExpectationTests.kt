/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package com.tsuharesu.expectations.tests

import com.tsuharesu.expectations.* // ktlint-disable no-wildcard-imports
import org.junit.Test
import kotlin.test.assertFailsWith

class StringExpectationTests {

    @Test
    fun toBeEmpty() {

        expect("").toBeEmpty()

        assertFailsWith(AssertionError::class, {
            expect("james").toBeEmpty()
        })

        assertFailsWith(AssertionError::class, {
            expect("     ").toBeEmpty()
        })

        "".should.beEmpty()

        assertFailsWith(AssertionError::class, {
            "pass".should.beEmpty()
        })
    }

    @Test
    fun toNotBeEmpty() {

        expect("james").toNotBeEmpty()

        assertFailsWith(AssertionError::class, {
            expect("").toNotBeEmpty()
        })

        expect("     ").toNotBeEmpty()

        "james".should.notBeEmpty()

        assertFailsWith(AssertionError::class, {
            "".should.notBeEmpty()
        })
    }

    @Test
    fun toHaveLengthOf() {
        expect("james").toHaveLengthOf(5)

        assertFailsWith(AssertionError::class, {
            expect("james").toHaveLengthOf(12)
        })

        "james".should.haveLengthOf(5)

        assertFailsWith(AssertionError::class, {
            "james".should.haveLengthOf(12)
        })
    }

    @Test
    fun toBeBlank() {
        expect("").toBeBlank()
        expect("   ").toBeBlank()

        "".should.beBlank()
        "    ".should.beBlank()

        assertFailsWith(AssertionError::class, {
            expect("james").toBeBlank()
        })

        assertFailsWith(AssertionError::class, {
            "james".should.beBlank()
        })
    }

    @Test
    fun toNotBeBlank() {
        expect("james").toNotBeBlank()
        expect("  james ").toNotBeBlank()

        "james".should.notBeBlank()
        "   james ".should.notBeBlank()

        assertFailsWith(AssertionError::class, {
            expect("").toNotBeBlank()
        })

        assertFailsWith(AssertionError::class, {
            expect("     ").toNotBeBlank()
        })

        assertFailsWith(AssertionError::class, {
            "".should.notBeBlank()
        })

        assertFailsWith(AssertionError::class, {
            "    ".should.notBeBlank()
        })
    }

    @Test
    fun toEndWith() {
        expect("james").toEndWith("s")

        assertFailsWith(AssertionError::class, {
            expect("james").toEndWith("j")
        })

        "james".should.endWith("s")

        assertFailsWith(AssertionError::class, {
            "james".should.endWith("j")
        })
    }

    @Test
    fun toContain() {
        expect("james").toContain("ame")

        assertFailsWith(AssertionError::class, {
            expect("james").toContain("nope")
        })

        "james".should.contain("ame")

        assertFailsWith(AssertionError::class, {
            "james".should.contain("nope")
        })
    }

    @Test
    fun toNotContain() {
        expect("james").toNotContain("nope")

        assertFailsWith(AssertionError::class, {
            expect("james").toNotContain("ame")
        })

        "james".should.notContain("nope")

        assertFailsWith(AssertionError::class, {
            "james".should.notContain("ame")
        })
    }

    @Test
    fun toStartWith() {
        expect("james").toStartWith("j")

        assertFailsWith(AssertionError::class, {
            expect("james").toStartWith("s")
        })

        "james".should.startWith("j")

        assertFailsWith(AssertionError::class, {
            "james".should.startWith("s")
        })
    }

    @Test
    fun toMatch() {
        expect("james").toMatch("^james$")

        assertFailsWith(AssertionError::class, {
            expect("james").toMatch("^fail$")
        })

        "james".should.match("^james$")

        assertFailsWith(AssertionError::class, {
            "james".should.match("^fail$")
        })
    }

    @Test
    fun toBeEquivalentTo() {
        expect("james").toBeEquivalentTo("James")

        "james".should.beEquivalentTo("James")
    }

    @Test
    fun toContainEquivalent() {
        expect("james").toContainEquivalent("aMe")

        "james".should.containEquivalent("aMe")
    }

    @Test
    fun toNotContainEquivalent() {
        assertFailsWith(AssertionError::class, {
            expect("james").toNotContainEquivalent("aMe")
        })

        assertFailsWith(AssertionError::class, {
            "james".should.notContainEquivalent("aMe")
        })
    }

    @Test
    fun toStartWithEquivalent() {
        expect("james").toStartWithEquivalent("J")

        "james".should.startWithEquivalent("J")
    }

    @Test
    fun toEndWithEquivalent() {
        expect("james").toEndWithEquivalent("S")

        "james".should.endWithEquivalent("S")
    }
}