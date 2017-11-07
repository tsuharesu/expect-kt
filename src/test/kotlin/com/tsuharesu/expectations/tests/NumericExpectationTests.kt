/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations.tests

import com.tsuharesu.expectations.* // ktlint-disable no-wildcard-imports
import org.junit.Test
import kotlin.test.assertFailsWith

class NumericExpectationTests {

    @Test
    fun toBeGreaterOrEqualTo() {
        // Int
        expect(2).toBeGreaterOrEqualTo(1)
        expect(2).toBeGreaterOrEqualTo(2)
        assertFailsWith(AssertionError::class, {
            expect(2).toBeGreaterOrEqualTo(3)
        })

        2.should.beGreaterOrEqualTo(1)
        2.should.beGreaterOrEqualTo(2)
        assertFailsWith(AssertionError::class, {
            2.should.beGreaterOrEqualTo(3)
        })

        // Long
        expect(2.toLong()).toBeGreaterOrEqualTo(1)
        expect(2.toLong()).toBeGreaterOrEqualTo(2)
        assertFailsWith(AssertionError::class, {
            expect(2.toLong()).toBeGreaterOrEqualTo(3)
        })

        2.toLong().should.beGreaterOrEqualTo(1)
        2.toLong().should.beGreaterOrEqualTo(2)
        assertFailsWith(AssertionError::class, {
            2.toLong().should.beGreaterOrEqualTo(3)
        })

        // Double
        expect(2.toDouble()).toBeGreaterOrEqualTo(1.0)
        expect(2.toDouble()).toBeGreaterOrEqualTo(2.0)
        assertFailsWith(AssertionError::class, {
            expect(2.toDouble()).toBeGreaterOrEqualTo(3.0)
        })

        2.toDouble().should.beGreaterOrEqualTo(1.0)
        2.toDouble().should.beGreaterOrEqualTo(2.0)
        assertFailsWith(AssertionError::class, {
            2.toDouble().should.beGreaterOrEqualTo(3.0)
        })

        // Float
        expect(2.toFloat()).toBeGreaterOrEqualTo(1f)
        expect(2.toFloat()).toBeGreaterOrEqualTo(2f)
        assertFailsWith(AssertionError::class, {
            expect(2.toFloat()).toBeGreaterOrEqualTo(3f)
        })

        2.toFloat().should.beGreaterOrEqualTo(1f)
        2.toFloat().should.beGreaterOrEqualTo(2f)
        assertFailsWith(AssertionError::class, {
            2.toFloat().should.beGreaterOrEqualTo(3f)
        })
    }

    @Test
    fun toBeGreaterThan() {
        // Int
        expect(2).toBeGreaterThan(1)
        assertFailsWith(AssertionError::class, {
            expect(2).toBeGreaterThan(2)
        })
        assertFailsWith(AssertionError::class, {
            expect(2).toBeGreaterThan(3)
        })

        2.should.beGreaterThan(1)
        assertFailsWith(AssertionError::class, {
            2.should.beGreaterThan(2)
        })
        assertFailsWith(AssertionError::class, {
            2.should.beGreaterThan(3)
        })

        // Long
        expect(2.toLong()).toBeGreaterThan(1)
        assertFailsWith(AssertionError::class, {
            expect(2.toLong()).toBeGreaterThan(2)
        })
        assertFailsWith(AssertionError::class, {
            expect(2.toLong()).toBeGreaterThan(3)
        })

        2.toLong().should.beGreaterThan(1)
        assertFailsWith(AssertionError::class, {
            2.toLong().should.beGreaterThan(2)
        })
        assertFailsWith(AssertionError::class, {
            2.toLong().should.beGreaterThan(3)
        })

        // Double
        expect(2.toDouble()).toBeGreaterThan(1.0)
        assertFailsWith(AssertionError::class, {
            expect(2.toDouble()).toBeGreaterThan(2.0)
        })
        assertFailsWith(AssertionError::class, {
            expect(2.toDouble()).toBeGreaterThan(3.0)
        })

        2.toDouble().should.beGreaterThan(1.0)
        assertFailsWith(AssertionError::class, {
            2.toDouble().should.beGreaterThan(2.0)
        })
        assertFailsWith(AssertionError::class, {
            2.toDouble().should.beGreaterThan(3.0)
        })

        // Float
        expect(2.toFloat()).toBeGreaterThan(1f)
        assertFailsWith(AssertionError::class, {
            expect(2.toFloat()).toBeGreaterThan(2f)
        })
        assertFailsWith(AssertionError::class, {
            expect(2.toFloat()).toBeGreaterThan(3f)
        })

        2.toFloat().should.beGreaterThan(1f)
        assertFailsWith(AssertionError::class, {
            2.toFloat().should.beGreaterThan(2f)
        })
        assertFailsWith(AssertionError::class, {
            2.toFloat().should.beGreaterThan(3f)
        })
    }

    @Test
    fun toBeLessOrEqualTo() {
        // Int
        expect(1).toBeLessOrEqualTo(2)
        expect(1).toBeLessOrEqualTo(1)
        assertFailsWith(AssertionError::class, {
            expect(2).toBeLessOrEqualTo(1)
        })

        1.should.beLessOrEqualTo(2)
        1.should.beLessOrEqualTo(1)
        assertFailsWith(AssertionError::class, {
            2.should.beLessOrEqualTo(1)
        })

        // Double
        expect(1.toDouble()).toBeLessOrEqualTo(2.0)
        expect(1.toDouble()).toBeLessOrEqualTo(1.0)
        assertFailsWith(AssertionError::class, {
            expect(2.toDouble()).toBeLessOrEqualTo(1.0)
        })

        1.toDouble().should.beLessOrEqualTo(2.0)
        1.toDouble().should.beLessOrEqualTo(1.0)
        assertFailsWith(AssertionError::class, {
            2.toDouble().should.beLessOrEqualTo(1.0)
        })

        // Long
        expect(1.toLong()).toBeLessOrEqualTo(2)
        expect(1.toLong()).toBeLessOrEqualTo(1)
        assertFailsWith(AssertionError::class, {
            expect(2.toLong()).toBeLessOrEqualTo(1)
        })

        1.toLong().should.beLessOrEqualTo(2)
        1.toLong().should.beLessOrEqualTo(1)
        assertFailsWith(AssertionError::class, {
            2.toLong().should.beLessOrEqualTo(1)
        })

        // Float
        expect(1.toFloat()).toBeLessOrEqualTo(2f)
        expect(1.toFloat()).toBeLessOrEqualTo(1f)
        assertFailsWith(AssertionError::class, {
            expect(2.toFloat()).toBeLessOrEqualTo(1f)
        })

        1.toFloat().should.beLessOrEqualTo(2f)
        1.toFloat().should.beLessOrEqualTo(1f)
        assertFailsWith(AssertionError::class, {
            2.toFloat().should.beLessOrEqualTo(1f)
        })
    }

    @Test
    fun toBeLessThan() {
        // Int
        expect(1).toBeLessThan(2)
        assertFailsWith(AssertionError::class, {
            expect(2).toBeLessThan(2)
        })

        1.should.beLessThan(2)
        assertFailsWith(AssertionError::class, {
            2.should.beLessThan(2)
        })

        // Long
        expect(1.toLong()).toBeLessThan(2)
        assertFailsWith(AssertionError::class, {
            expect(2.toLong()).toBeLessThan(2)
        })

        1.toLong().should.beLessThan(2)
        assertFailsWith(AssertionError::class, {
            2.toLong().should.beLessThan(2)
        })

        // Double
        expect(1.toDouble()).toBeLessThan(1.1)
        assertFailsWith(AssertionError::class, {
            expect(2.toDouble()).toBeLessThan(2.0)
        })

        1.toDouble().should.beLessThan(1.1)
        assertFailsWith(AssertionError::class, {
            2.toDouble().should.beLessThan(2.0)
        })

        // Float
        expect(1.toFloat()).toBeLessThan(2f)
        assertFailsWith(AssertionError::class, {
            expect(2.toFloat()).toBeLessThan(2f)
        })

        1.toFloat().should.beLessThan(2f)
        assertFailsWith(AssertionError::class, {
            2.toFloat().should.beLessThan(2f)
        })
    }

    @Test
    fun toBeInRange() {
        // Int
        expect(2).toBeInRange(1, 3)
        expect(2).toBeInRange(2, 2)

        assertFailsWith(AssertionError::class, {
            expect(2).toBeInRange(3, 6)
        })

        2.should.beInRange(1, 3)
        2.should.beInRange(2, 2)

        assertFailsWith(AssertionError::class, {
            2.should.beInRange(3, 6)
        })

        // Long
        expect(2.toLong()).toBeInRange(1, 3)
        expect(2.toLong()).toBeInRange(2, 2)

        assertFailsWith(AssertionError::class, {
            expect(2.toLong()).toBeInRange(3, 6)
        })

        2.toLong().should.beInRange(1, 3)
        2.toLong().should.beInRange(2, 2)

        assertFailsWith(AssertionError::class, {
            2.toLong().should.beInRange(3, 6)
        })

        // Double
        expect(2.0).toBeInRange(1.0, 2.1)
        expect(2.0).toBeInRange(2.0, 2.0)

        assertFailsWith(AssertionError::class, {
            expect(2.0).toBeInRange(3.0, 6.0)
        })

        2.0.should.beInRange(1.0, 2.1)
        2.0.should.beInRange(2.0, 2.0)

        assertFailsWith(AssertionError::class, {
            2.0.should.beInRange(3.0, 6.0)
        })

        // Float
        expect(2f).toBeInRange(1f, 2.1f)
        expect(2f).toBeInRange(2f, 2f)

        assertFailsWith(AssertionError::class, {
            expect(2f).toBeInRange(3f, 6f)
        })

        2f.should.beInRange(1f, 2.1f)
        2f.should.beInRange(2f, 2f)

        assertFailsWith(AssertionError::class, {
            2f.should.beInRange(3f, 6f)
        })
    }

    @Test
    fun toBeApproximately() {
        // Int
        expect(2).toBeApproximately(4, 2)
        expect(4).toBeApproximately(2, 2)

        assertFailsWith(AssertionError::class, {
            expect(2).toBeApproximately(8, 5)
        })

        2.should.beApproximately(4, 2)
        4.should.beApproximately(2, 2)

        assertFailsWith(AssertionError::class, {
            2.should.beApproximately(8, 5)
        })

        // Long
        expect(2.toLong()).toBeApproximately(4, 2)
        expect(4.toLong()).toBeApproximately(2, 2)

        assertFailsWith(AssertionError::class, {
            expect(2.toLong()).toBeApproximately(8, 5)
        })

        2.toLong().should.beApproximately(4, 2)
        4.toLong().should.beApproximately(2, 2)

        assertFailsWith(AssertionError::class, {
            2.toLong().should.beApproximately(8, 5)
        })

        // Double
        expect(2.0).toBeApproximately(2.1, 0.1)
        expect(2.0).toBeApproximately(1.9, 0.1)

        assertFailsWith(AssertionError::class, {
            expect(2.0).toBeApproximately(2.8, 0.5)
        })

        2.0.should.beApproximately(2.1, 0.1)
        2.0.should.beApproximately(1.9, 0.1)

        assertFailsWith(AssertionError::class, {
            2.0.should.beApproximately(2.8, 0.5)
        })

        // Float
        expect(2f).toBeApproximately(2.1f, 0.1f)
        expect(2f).toBeApproximately(1.9f, 0.1f)

        assertFailsWith(AssertionError::class, {
            expect(2f).toBeApproximately(2.8f, 0.5f)
        })

        2f.should.beApproximately(2.1f, 0.1f)
        2f.should.beApproximately(1.9f, 0.1f)

        assertFailsWith(AssertionError::class, {
            2f.should.beApproximately(2.8f, 0.5f)
        })
    }
}