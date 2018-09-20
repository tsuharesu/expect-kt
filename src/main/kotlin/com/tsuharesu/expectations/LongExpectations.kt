/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Tsuharesu
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun Expectation<Long>.toBeGreaterOrEqualTo(value: Long): ExpectationChain<Long> {
    assertTrue(target >= value, "$target expected to be greater than or equal to $value")
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeGreaterThan(value: Long): ExpectationChain<Long> {
    assertTrue(target > value, "$target expected to be greater than $value")
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeLessOrEqualTo(value: Long): ExpectationChain<Long> {
    assertTrue(target <= value, "$target expected to be less than or equal to $value")
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeLessThan(value: Long): ExpectationChain<Long> {
    assertTrue(target < value, "$target expected to be less than $value")
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeInRange(lower: Long, upper: Long): ExpectationChain<Long> {
    assertTrue(target in lower..upper, "$target expected to be between $lower and $upper")
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeApproximately(value: Long, tolerance: Long): ExpectationChain<Long> {
    return expect(target).toBeInRange(value - tolerance, value + tolerance)
}

val Long.should: Should<Long> get() = Should(this)

fun Should<Long>.beGreaterOrEqualTo(value: Long): ShouldChain<Long> {
    expectation.toBeGreaterOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Long>.beGreaterThan(value: Long): ShouldChain<Long> {
    expectation.toBeGreaterThan(value)
    return ShouldChain(this)
}

fun Should<Long>.beLessOrEqualTo(value: Long): ShouldChain<Long> {
    expectation.toBeLessOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Long>.beLessThan(value: Long): ShouldChain<Long> {
    expectation.toBeLessThan(value)
    return ShouldChain(this)
}

fun Should<Long>.beInRange(lower: Long, upper: Long): ShouldChain<Long> {
    expectation.toBeInRange(lower, upper)
    return ShouldChain(this)
}

fun Should<Long>.beApproximately(value: Long, tolerance: Long): ShouldChain<Long> {
    expectation.toBeApproximately(value, tolerance)
    return ShouldChain(this)
}