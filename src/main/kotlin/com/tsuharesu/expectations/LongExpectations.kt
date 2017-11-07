/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun Expectation<Long>.toBeGreaterOrEqualTo(value: Long): ExpectationChain<Long> {
    assertTrue(target >= value)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeGreaterThan(value: Long): ExpectationChain<Long> {
    assertTrue(target > value)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeLessOrEqualTo(value: Long): ExpectationChain<Long> {
    assertTrue(target <= value)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeLessThan(value: Long): ExpectationChain<Long> {
    assertTrue(target < value)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeInRange(lower: Long, upper: Long): ExpectationChain<Long> {
    assertTrue(target in lower..upper)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeApproximately(value: Long, tolerance: Long): ExpectationChain<Long> {
    return expect(target).toBeInRange(value - tolerance, value + tolerance)
}

val Long.should: Should<Long> get() = Should(this)

fun Should<Long>.beGreaterOrEqualTo(value: Long): ShouldChain<Long> {
    expector.toBeGreaterOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Long>.beGreaterThan(value: Long): ShouldChain<Long> {
    expector.toBeGreaterThan(value)
    return ShouldChain(this)
}

fun Should<Long>.beLessOrEqualTo(value: Long): ShouldChain<Long> {
    expector.toBeLessOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Long>.beLessThan(value: Long): ShouldChain<Long> {
    expector.toBeLessThan(value)
    return ShouldChain(this)
}

fun Should<Long>.beInRange(lower: Long, upper: Long): ShouldChain<Long> {
    expector.toBeInRange(lower, upper)
    return ShouldChain(this)
}

fun Should<Long>.beApproximately(value: Long, tolerance: Long): ShouldChain<Long> {
    expector.toBeApproximately(value, tolerance)
    return ShouldChain(this)
}