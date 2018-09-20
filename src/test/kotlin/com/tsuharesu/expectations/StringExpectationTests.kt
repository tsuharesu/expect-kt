/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import org.junit.Test
import kotlin.test.assertFailsWith

class StringExpectationTests {

    @Test
    fun toBeEmpty() {
        expect("").toBeEmpty()

        assertFailsWith(AssertionError::class) {
            expect("james").toBeEmpty()
        }.message.should.be("james expected to be empty")

        assertFailsWith(AssertionError::class) {
            expect("     ").toBeEmpty()
        }.message.should.be("      expected to be empty")

        "".should.beEmpty()

        assertFailsWith(AssertionError::class) {
            "james".should.beEmpty()
        }.message.should.be("james expected to be empty")
    }

    @Test
    fun toNotBeEmpty() {
        expect("james").toNotBeEmpty()

        assertFailsWith(AssertionError::class) {
            expect("").toNotBeEmpty()
        }.message.should.be("expected to not be empty")

        expect("     ").toNotBeEmpty()

        "james".should.notBeEmpty()

        assertFailsWith(AssertionError::class) {
            "".should.notBeEmpty()
        }.message.should.be("expected to not be empty")
    }

    @Test
    fun toHaveLengthOf() {
        expect("james").toHaveLengthOf(5)

        assertFailsWith(AssertionError::class) {
            expect("james").toHaveLengthOf(12)
        }.message.should.be("expected to have length 12 but have length 5")

        "james".should.haveLengthOf(5)

        assertFailsWith(AssertionError::class) {
            "james".should.haveLengthOf(12)
        }.message.should.be("expected to have length 12 but have length 5")
    }

    @Test
    fun toBeBlank() {
        expect("").toBeBlank()

        expect("   ").toBeBlank()

        assertFailsWith(AssertionError::class) {
            expect("james").toBeBlank()
        }.message.should.be("james expected to be blank")

        "".should.beBlank()

        "    ".should.beBlank()

        assertFailsWith(AssertionError::class) {
            "james".should.beBlank()
        }.message.should.be("james expected to be blank")
    }

    @Test
    fun toNotBeBlank() {
        expect("james").toNotBeBlank()

        expect("  james ").toNotBeBlank()

        assertFailsWith(AssertionError::class) {
            expect("").toNotBeBlank()
        }.message.should.be("expected to not be blank")

        assertFailsWith(AssertionError::class) {
            expect("     ").toNotBeBlank()
        }.message.should.be("expected to not be blank")

        "james".should.notBeBlank()

        "   james ".should.notBeBlank()

        assertFailsWith(AssertionError::class) {
            "".should.notBeBlank()
        }.message.should.be("expected to not be blank")

        assertFailsWith(AssertionError::class) {
            "    ".should.notBeBlank()
        }.message.should.be("expected to not be blank")
    }

    @Test
    fun toBeEquivalentTo() {
        expect("james").toBeEquivalentTo("James")

        assertFailsWith(AssertionError::class) {
            expect("james").toBeEquivalentTo("Tsu")
        }.message.should.be("james expected to be equivalent to Tsu")

        "james".should.beEquivalentTo("James")

        assertFailsWith(AssertionError::class) {
            "james".should.beEquivalentTo("Tsu")
        }.message.should.be("james expected to be equivalent to Tsu")
    }

    @Test
    fun toStartWith() {
        expect("james").toStartWith("j")

        assertFailsWith(AssertionError::class) {
            expect("james").toStartWith("s")
        }.message.should.be("james expected to start with s")

        "james".should.startWith("j")

        assertFailsWith(AssertionError::class) {
            "james".should.startWith("s")
        }.message.should.be("james expected to start with s")
    }

    @Test
    fun toStartWithEquivalent() {
        expect("james").toStartWithEquivalent("J")

        assertFailsWith(AssertionError::class) {
            expect("james").toStartWithEquivalent("S")
        }.message.should.be("james expected to start with equivalent to S")

        "james".should.startWithEquivalent("J")

        assertFailsWith(AssertionError::class) {
            "james".should.startWithEquivalent("S")
        }.message.should.be("james expected to start with equivalent to S")
    }

    @Test
    fun toEndWith() {
        expect("james").toEndWith("s")

        assertFailsWith(AssertionError::class) {
            expect("james").toEndWith("j")
        }.message.should.be("james expected to end with j")

        "james".should.endWith("s")

        assertFailsWith(AssertionError::class) {
            "james".should.endWith("j")
        }.message.should.be("james expected to end with j")
    }

    @Test
    fun toEndWithEquivalent() {
        expect("james").toEndWithEquivalent("S")

        assertFailsWith(AssertionError::class) {
            expect("james").toEndWithEquivalent("J")
        }.message.should.be("james expected to end with equivalent to J")

        "james".should.endWithEquivalent("S")

        assertFailsWith(AssertionError::class) {
            "james".should.endWithEquivalent("J")
        }.message.should.be("james expected to end with equivalent to J")
    }

    @Test
    fun toContain() {
        expect("james").toContain("ame")

        assertFailsWith(AssertionError::class) {
            expect("james").toContain("tsu")
        }.message.should.be("james expected to contain tsu")

        "james".should.contain("ame")

        assertFailsWith(AssertionError::class) {
            "james".should.contain("tsu")
        }.message.should.be("james expected to contain tsu")
    }

    @Test
    fun toContainEquivalent() {
        expect("james").toContainEquivalent("aMe")

        assertFailsWith(AssertionError::class) {
            expect("james").toContainEquivalent("Tsu")
        }.message.should.be("james expected to contain equivalent to Tsu")

        "james".should.containEquivalent("aMe")

        assertFailsWith(AssertionError::class) {
            "james".should.containEquivalent("Tsu")
        }.message.should.be("james expected to contain equivalent to Tsu")
    }

    @Test
    fun toNotContain() {
        expect("james").toNotContain("tsu")

        assertFailsWith(AssertionError::class) {
            expect("james").toNotContain("ame")
        }.message.should.be("james expected to not contain ame")

        "james".should.notContain("tsu")

        assertFailsWith(AssertionError::class) {
            "james".should.notContain("ame")
        }.message.should.be("james expected to not contain ame")
    }

    @Test
    fun toNotContainEquivalent() {
        expect("james").toNotContainEquivalent("Tsu")

        assertFailsWith(AssertionError::class) {
            expect("james").toNotContainEquivalent("aMe")
        }.message.should.be("james expected to not contain equivalent to aMe")

        "james".should.notContainEquivalent("Tsu")

        assertFailsWith(AssertionError::class) {
            "james".should.notContainEquivalent("aMe")
        }.message.should.be("james expected to not contain equivalent to aMe")
    }

    @Test
    fun toMatch() {
        expect("james").toMatch(Regex("^james$"))

        assertFailsWith(AssertionError::class) {
            expect("james").toMatch(Regex("^tsu$"))
        }.message.should.be("james expected to match ^tsu$")

        "james".should.match(Regex("^james$"))

        assertFailsWith(AssertionError::class) {
            "james".should.match(Regex("^tsu$"))
        }.message.should.be("james expected to match ^tsu$")
    }
}