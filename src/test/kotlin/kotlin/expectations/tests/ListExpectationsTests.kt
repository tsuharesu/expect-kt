/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations.tests

import org.junit.Test
import kotlin.expectations.*
import kotlin.test.assertFailsWith

class ListExpectationsTests {
    @Test fun toBeEmpty() {
        expect(listOf<String>()).toBeEmpty()

        listOf<String>().should.beEmpty()
    }

    @Test fun toNotBeEmpty() {
        expect(listOf("james")).toNotBeEmpty()

        listOf("james").should.notBeEmpty()
    }

    @Test fun toHaveSize() {
        expect(listOf("james", "cindy")).toHaveSize(2)

        listOf("james", "cindy").should.haveSize(2)
    }

    @Test fun toHaveSameSizeAs() {
        expect(listOf("james", "cindy")).toHaveSameSizeAs(listOf(1, 2))

        listOf("james", "cindy").should.haveSameSizeAs(listOf(1, 2))
    }

    @Test fun toContain() {
        expect(listOf("james", "cindy")).toContain("james")

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "cindy")).toContain("tsu")
        }

        listOf("james", "cindy").should.contain("james")

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "cindy").should.contain("tsu")
        }
    }

    @Test fun toContainLambda() {
        expect(listOf(1, 2)).toContain { it > 1 }

        assertFailsWith(AssertionError::class.java) {
            expect(listOf(1, 2)).toContain { it > 2 }
        }

        listOf(1, 2).should.contain { it > 1 }

        assertFailsWith(AssertionError::class.java) {
            listOf(1, 2).should.contain { it > 2 }
        }
    }

    @Test fun toOnlyContain() {
        expect(listOf(2, 4, 6)).toOnlyContain { it.mod(2) == 0 }

        assertFailsWith(AssertionError::class.java) {
            expect(listOf(2, 4, 5)).toOnlyContain { it.mod(2) == 0 }
        }

        listOf(2, 4, 6).should.onlyContain { it.mod(2) == 0 }

        assertFailsWith(AssertionError::class.java) {
            listOf(2, 4, 5).should.onlyContain { it.mod(2) == 0 }
        }
    }

    @Test fun toContainAll() {
        expect(listOf("james", "cindy")).toContainAll(listOf("james"))

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "cindy")).toContainAll(listOf("james", "cindy", "tsu"))
        }

        listOf("james", "cindy").should.containAll(listOf("james"))

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "cindy").should.containAll(listOf("james", "cindy", "tsu"))
        }
    }

    @Test fun toContainNull() {
        expect(listOf("james", null)).toContainNull()

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "cindy")).toContainNull()
        }

        listOf("james", null).should.containNull()

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "cindy").should.containNull()
        }
    }

    @Test fun toNotContain() {
        expect(listOf("james", "cindy")).toNotContain("tsu")

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "cindy")).toNotContain("james")
        }

        listOf("james", "cindy").should.notContain("tsu")

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "cindy").should.notContain("james")
        }
    }

    @Test fun toNotContainLambda() {
        expect(listOf(1, 2)).toNotContain { it > 2 }

        assertFailsWith(AssertionError::class.java) {
            expect(listOf(1, 2)).toNotContain { it > 1 }
        }

        listOf(1, 2).should.notContain { it > 2 }

        assertFailsWith(AssertionError::class.java) {
            listOf(1, 2).should.notContain { it > 1 }
        }
    }

    @Test fun toNotContainAny() {
        expect(listOf("james", "cindy")).toNotContainAny(listOf("tsu"))

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "cindy")).toNotContainAny(listOf("tsu", "james"))
        }

        listOf("james", "cindy").should.notContainAny(listOf("tsu"))

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "cindy").should.notContainAny(listOf("tsu", "james"))
        }
    }

    @Test fun toNotContainNull() {
        expect(listOf("james", "cindy")).toNotContainNull()

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", null)).toNotContainNull()
        }

        listOf("james", "cindy").should.notContainNull()

        assertFailsWith(AssertionError::class.java) {
            listOf("james", null).should.notContainNull()
        }
    }

    @Test fun toStartWith() {
        expect(listOf("james", "cindy")).toStartWith("james")

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "cindy")).toStartWith("cindy")
        }

        listOf("james", "cindy").should.startWith("james")

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "cindy").should.startWith("cindy")
        }
    }

    @Test fun toEndWith() {
        expect(listOf("james", "cindy")).toEndWith("cindy")

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "cindy")).toEndWith("james")
        }

        listOf("james", "cindy").should.endWith("cindy")

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "cindy").should.endWith("james")
        }
    }

    @Test fun toHaveItemAt() {
        expect(listOf("james", "cindy")).toHaveItemAt("cindy", 1)

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "cindy")).toHaveItemAt("cindy", 0)
        }

        listOf("james", "cindy").should.haveItemAt("cindy", 1)

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "cindy").should.haveItemAt("cindy", 0)
        }
    }

    @Test fun toNotContainDuplicates() {
        expect(listOf("james", "cindy")).toNotContainDuplicates()

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "james")).toNotContainDuplicates()
        }

        listOf("james", "cindy").should.notContainDuplicates()

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "james").should.notContainDuplicates()
        }
    }

    @Test fun toBeSubsetOf() {
        expect(listOf("james", "cindy")).toBeSubsetOf(listOf("james", "cindy", "tsu", "aphrodite"))

        assertFailsWith(AssertionError::class.java) {
            expect(listOf("james", "cindy")).toBeSubsetOf(listOf("james", "tsu", "aphrodite"))
        }

        listOf("james", "cindy").should.beSubsetOf(listOf("james", "cindy", "tsu", "aphrodite"))

        assertFailsWith(AssertionError::class.java) {
            listOf("james", "cindy").should.beSubsetOf(listOf("james", "tsu", "aphrodite"))
        }
    }
}