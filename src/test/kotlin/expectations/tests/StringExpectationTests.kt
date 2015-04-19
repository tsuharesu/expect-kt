/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations.tests

import kotlin.expectations.*
import kotlin.test.failsWith
import org.junit.Test as test


class StringExpectationTests {

    test fun toBeEmpty() {

        expect("").toBeEmpty()

        failsWith(javaClass<AssertionError>()) {
            expect("james").toBeEmpty()
        }

        failsWith(javaClass<AssertionError>()) {
            expect("     ").toBeEmpty()
        }

        "".should.beEmpty()

        failsWith(javaClass<AssertionError>()) {
            "pass".should.beEmpty()
        }
    }

    test fun toNotBeEmpty() {

        expect("james").toNotBeEmpty()

        failsWith(javaClass<AssertionError>()) {
            expect("").toBeEmpty()
        }

        expect("     ").toNotBeEmpty()

        "james".should.notBeEmpty()

        failsWith(javaClass<AssertionError>()) {
            "".should.notBeEmpty()
        }
    }

    test fun toHaveLengthOf() {
        expect("james").toHaveLengthOf(5)

        failsWith(javaClass<AssertionError>()) {
            expect("james").toHaveLengthOf(12)
        }

        "james".should.haveLengthOf(5)

        failsWith(javaClass<AssertionError>()) {
            "james".should.haveLengthOf(12)
        }
    }

    test fun toBeBlank() {
        expect("").toBeBlank()
        expect("   ").toBeBlank()

        "".should.beBlank()
        "    ".should.beBlank()

        failsWith(javaClass<AssertionError>()) {
            expect("james").toBeBlank()
        }

        failsWith(javaClass<AssertionError>()) {
            "james".should.beBlank()
        }
    }

    test fun toNotBeBlank() {
        expect("james").toNotBeBlank()
        expect("  james ").toNotBeBlank()

        "james".should.notBeBlank()
        "   james ".should.notBeBlank()

        failsWith(javaClass<AssertionError>()) {
            expect("").toNotBeBlank()
        }

        failsWith(javaClass<AssertionError>()) {
            expect("     ").toNotBeBlank()
        }

        failsWith(javaClass<AssertionError>()) {
            "".should.notBeBlank()
        }

        failsWith(javaClass<AssertionError>()) {
            "    ".should.notBeBlank()
        }
    }

    test fun toEndWith() {
        expect("james").toEndWith("s")

        failsWith(javaClass<AssertionError>()) {
            expect("james").toEndWith("j")
        }

        "james".should.endWith("s")

        failsWith(javaClass<AssertionError>()) {
            "james".should.endWith("j")
        }
    }

    test fun toContain() {
        expect("james").toContain("ame")

        failsWith(javaClass<AssertionError>()) {
            expect("james").toContain("nope")
        }

        "james".should.contain("ame")

        failsWith(javaClass<AssertionError>()) {
            "james".should.contain("nope")
        }
    }

    test fun toNotContain() {
        expect("james").toNotContain("nope")

        failsWith(javaClass<AssertionError>()) {
            expect("james").toNotContain("ame")
        }

        "james".should.notContain("nope")

        failsWith(javaClass<AssertionError>()) {
            "james".should.notContain("ame")
        }
    }

    test fun toStartWith() {
        expect("james").toStartWith("j")

        failsWith(javaClass<AssertionError>()) {
            expect("james").toStartWith("s")
        }

        "james".should.startWith("j")

        failsWith(javaClass<AssertionError>()) {
            "james".should.startWith("s")
        }
    }

    test fun toMatch() {
        expect("james").toMatch("^james$")

        failsWith(javaClass<AssertionError>()) {
            expect("james").toMatch("^fail$")
        }

        "james".should.match("^james$")

        failsWith(javaClass<AssertionError>()) {
            "james".should.match("^fail$")
        }
    }

    test fun toEndWithEquivalent() {
        expect("james").toEndWithEquivalent("S")

        "james".should.endWithEquivalent("S")
    }

    test fun toContainEquivalent() {
        expect("james").toContainEquivalent("aMe")

        "james".should.containEquivalent("aMe")
    }

    test fun toNotContainEquivalent() {
        failsWith(javaClass<AssertionError>()) {
            expect("james").toNotContainEquivalent("aMe")
        }

        failsWith(javaClass<AssertionError>()) {
            "james".should.notContainEquivalent("aMe")
        }
    }

    test fun toStartWithEquivalent() {
        expect("james").toStartWithEquivalent("J")

        "james".should.startWithEquivalent("J")
    }
}