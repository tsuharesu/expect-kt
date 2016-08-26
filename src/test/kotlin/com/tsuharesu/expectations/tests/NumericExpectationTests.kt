/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package com.tsuharesu.expectations.tests

import com.tsuharesu.expectations.*
import kotlin.test.assertFailsWith
import org.junit.Test as test

class NumericExpectationTests {

    @org.junit.Test fun toBeGreaterOrEqualTo() {
        // Int
        expect(2.toInt()).toBeGreaterOrEqualTo(1)
        expect(2.toInt()).toBeGreaterOrEqualTo(2)
        assertFailsWith(AssertionError::class, {
            expect(2.toInt()).toBeGreaterOrEqualTo(3)
        })

        2.toInt().should.beGreaterOrEqualTo(1)
        2.toInt().should.beGreaterOrEqualTo(2)
        assertFailsWith(AssertionError::class, {
            2.toInt().should.beGreaterOrEqualTo(3)
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

    @org.junit.Test fun toBeGreaterThan() {
        // Int
        expect(2.toInt()).toBeGreaterThan(1)
        assertFailsWith(AssertionError::class, {
            expect(2.toInt()).toBeGreaterThan(2)
        })
        assertFailsWith(AssertionError::class, {
            expect(2.toInt()).toBeGreaterThan(3)
        })

        2.toInt().should.beGreaterThan(1)
        assertFailsWith(AssertionError::class, {
            2.toInt().should.beGreaterThan(2)
        })
        assertFailsWith(AssertionError::class, {
            2.toInt().should.beGreaterThan(3)
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

    @org.junit.Test fun toBeLessOrEqualTo() {
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

    @org.junit.Test fun toBeLessThan() {
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

    @org.junit.Test fun toBeInRange() {
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
    }

    @org.junit.Test fun toBeApproximately() {
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