/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Tsuharesu
 */

package com.tsuharesu.expectations

import org.junit.Test
import kotlin.test.assertFailsWith

class ListExpectationsTests {
    @Test
    fun toBeEmpty() {
        expect(listOf<String>()).toBeEmpty()

        assertFailsWith(AssertionError::class) {
            expect(listOf("james")).toBeEmpty()
        }.message.should.be("list with size 1 expected to be empty")

        listOf<String>().should.beEmpty()

        assertFailsWith(AssertionError::class) {
            listOf("james").should.beEmpty()
        }.message.should.be("list with size 1 expected to be empty")
    }

    @Test
    fun toNotBeEmpty() {
        expect(listOf("james")).toNotBeEmpty()

        assertFailsWith(AssertionError::class) {
            expect(listOf<String>()).toNotBeEmpty()
        }.message.should.be("list expected to not be empty")

        listOf("james").should.notBeEmpty()

        assertFailsWith(AssertionError::class) {
            listOf<String>().should.notBeEmpty()
        }.message.should.be("list expected to not be empty")
    }

    @Test
    fun toHaveSize() {
        expect(listOf("james", "cindy")).toHaveSize(2)

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toHaveSize(3)
        }.message.should.be("list with size 2 expected to have size 3")

        listOf("james", "cindy").should.haveSize(2)

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.haveSize(3)
        }.message.should.be("list with size 2 expected to have size 3")
    }

    @Test
    fun toHaveSameSizeAs() {
        expect(listOf("james", "cindy")).toHaveSameSizeAs(listOf(1, 2))

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toHaveSameSizeAs(listOf(1, 2, 3))
        }.message.should.be("list with size 2 expected to have size 3")

        listOf("james", "cindy").should.haveSameSizeAs(listOf(1, 2))

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.haveSameSizeAs(listOf(1, 2, 3))
        }.message.should.be("list with size 2 expected to have size 3")
    }

    @Test
    fun toContain() {
        expect(listOf("james", "cindy")).toContain("james")

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toContain("tsu")
        }.message.should.be("[james, cindy] expected to contain tsu")

        listOf("james", "cindy").should.contain("james")

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.contain("tsu")
        }.message.should.be("[james, cindy] expected to contain tsu")
    }

    @Test
    fun toContainAll() {
        expect(listOf("james", "cindy")).toContainAll(listOf("james"))

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toContainAll(listOf("james", "cindy", "tsu"))
        }.message.should.be("[james, cindy] expected to contain [james, cindy, tsu]")

        listOf("james", "cindy").should.containAll(listOf("james"))

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.containAll(listOf("james", "cindy", "tsu"))
        }.message.should.be("[james, cindy] expected to contain [james, cindy, tsu]")
    }

    @Test
    fun toContainNull() {
        expect(listOf("james", null)).toContainNull()

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toContainNull()
        }.message.should.be("[james, cindy] expected to contain null")

        listOf("james", null).should.containNull()

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.containNull()
        }.message.should.be("[james, cindy] expected to contain null")
    }

    @Test
    fun toNotContainNull() {
        expect(listOf("james", "cindy")).toNotContainNull()

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", null)).toNotContainNull()
        }.message.should.be("[james, null] expected to not contain null")

        listOf("james", "cindy").should.notContainNull()

        assertFailsWith(AssertionError::class) {
            listOf("james", null).should.notContainNull()
        }.message.should.be("[james, null] expected to not contain null")
    }

    @Test
    fun toNotContain() {
        expect(listOf("james", "cindy")).toNotContain("tsu")

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toNotContain("james")
        }.message.should.be("[james, cindy] expected to not contain james")

        listOf("james", "cindy").should.notContain("tsu")

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.notContain("james")
        }.message.should.be("[james, cindy] expected to not contain james")
    }

    @Test
    fun toNotContainAny() {
        expect(listOf("james", "cindy")).toNotContainAny(listOf("tsu"))

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toNotContainAny(listOf("tsu", "james"))
        }.message.should.be("[james, cindy] expected to not contain any item of list [tsu, james]")

        listOf("james", "cindy").should.notContainAny(listOf("tsu"))

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.notContainAny(listOf("tsu", "james"))
        }.message.should.be("[james, cindy] expected to not contain any item of list [tsu, james]")
    }

    @Test
    fun anyToMatchLambda() {
        expect(listOf(1, 2)).anyToMatchLambda { it > 1 }

        assertFailsWith(AssertionError::class) {
            expect(listOf(1, 2)).anyToMatchLambda { it > 2 }
        }.message.should.be("expected to find any item matching the lambda")

        listOf(1, 2).should.anyMatchLambda { it > 1 }

        assertFailsWith(AssertionError::class) {
            listOf(1, 2).should.anyMatchLambda { it > 2 }
        }.message.should.be("expected to find any item matching the lambda")
    }

    @Test
    fun allToMatchLambda() {
        expect(listOf(2, 4, 6)).allToMatchLambda { it.rem(2) == 0 }

        assertFailsWith(AssertionError::class) {
            expect(listOf(2, 4, 5)).allToMatchLambda { it.rem(2) == 0 }
        }.message.should.be("expected all items to match the lambda")

        listOf(2, 4, 6).should.allMatchLambda { it.rem(2) == 0 }

        assertFailsWith(AssertionError::class) {
            listOf(2, 4, 5).should.allMatchLambda { it.rem(2) == 0 }
        }.message.should.be("expected all items to match the lambda")
    }

    @Test
    fun noneToMatchLambda() {
        expect(listOf(1, 2)).noneToMatchLambda { it > 2 }

        assertFailsWith(AssertionError::class) {
            expect(listOf(1, 2)).noneToMatchLambda { it > 1 }
        }.message.should.be("expected that no items matched the lambda")

        listOf(1, 2).should.noneMatchLambda { it > 2 }

        assertFailsWith(AssertionError::class) {
            listOf(1, 2).should.noneMatchLambda { it > 1 }
        }.message.should.be("expected that no items matched the lambda")
    }

    @Test
    fun toStartWith() {
        expect(listOf("james", "cindy")).toStartWith("james")

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toStartWith("cindy")
        }.message.should.be("expected to start with cindy")

        listOf("james", "cindy").should.startWith("james")

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.startWith("cindy")
        }.message.should.be("expected to start with cindy")
    }

    @Test
    fun toEndWith() {
        expect(listOf("james", "cindy")).toEndWith("cindy")

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toEndWith("james")
        }.message.should.be("expected to end with james")

        listOf("james", "cindy").should.endWith("cindy")

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.endWith("james")
        }.message.should.be("expected to end with james")
    }

    @Test
    fun toHaveItemAt() {
        expect(listOf("james", "cindy")).toHaveItemAt("cindy", 1)

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toHaveItemAt("cindy", 0)
        }.message.should.be("expected to have item cindy at index 0")

        listOf("james", "cindy").should.haveItemAt("cindy", 1)

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.haveItemAt("cindy", 0)
        }.message.should.be("expected to have item cindy at index 0")
    }

    @Test
    fun toHaveInstanceOfItemAt() {
        expect(listOf("james", 1)).toHaveInstanceOfItemAt(String::class, 0)

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", 1)).toHaveInstanceOfItemAt(String::class, 1)
        }.message.should.be("1 expected to be instance of String")

        listOf("james", 1).should.haveInstanceOfItemAt(String::class, 0)

        assertFailsWith(AssertionError::class) {
            listOf("james", 1).should.haveInstanceOfItemAt(String::class, 1)
        }.message.should.be("1 expected to be instance of String")
    }

    @Test
    fun toNotContainDuplicates() {
        expect(listOf("james", "cindy")).toNotContainDuplicates()

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "james")).toNotContainDuplicates()
        }.message.should.be("expected to not contain duplicates")

        listOf("james", "cindy").should.notContainDuplicates()

        assertFailsWith(AssertionError::class) {
            listOf("james", "james").should.notContainDuplicates()
        }.message.should.be("expected to not contain duplicates")
    }

    @Test
    fun toBeSubsetOf() {
        expect(listOf("james", "cindy")).toBeSubsetOf(listOf("james", "cindy", "tsu", "tzu"))

        assertFailsWith(AssertionError::class) {
            expect(listOf("james", "cindy")).toBeSubsetOf(listOf("james", "tsu", "tzu"))
        }.message.should.be("expected to be a subset of [james, tsu, tzu]")

        listOf("james", "cindy").should.beSubsetOf(listOf("james", "cindy", "tsu", "tzu"))

        assertFailsWith(AssertionError::class) {
            listOf("james", "cindy").should.beSubsetOf(listOf("james", "tsu", "tzu"))
        }.message.should.be("expected to be a subset of [james, tsu, tzu]")
    }
}