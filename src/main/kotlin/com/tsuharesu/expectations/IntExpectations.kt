/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun Expectation<Int>.toBeGreaterOrEqualTo(value: Int): ExpectationChain<Int> {
    assertTrue(target >= value)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeGreaterThan(value: Int): ExpectationChain<Int> {
    assertTrue(target > value)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeLessOrEqualTo(value: Int): ExpectationChain<Int> {
    assertTrue(target <= value)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeLessThan(value: Int): ExpectationChain<Int> {
    assertTrue(target < value)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeInRange(lower: Int, upper: Int): ExpectationChain<Int> {
    assertTrue(target in lower..upper)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeApproximately(value: Int, tolerance: Int): ExpectationChain<Int> {
    return expect(target).toBeInRange(value - tolerance, value + tolerance)
}

val Int.should: Should<Int> get() = Should(this)

fun Should<Int>.beGreaterOrEqualTo(value: Int): ShouldChain<Int> {
    expectation.toBeGreaterOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Int>.beGreaterThan(value: Int): ShouldChain<Int> {
    expectation.toBeGreaterThan(value)
    return ShouldChain(this)
}

fun Should<Int>.beLessOrEqualTo(value: Int): ShouldChain<Int> {
    expectation.toBeLessOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Int>.beLessThan(value: Int): ShouldChain<Int> {
    expectation.toBeLessThan(value)
    return ShouldChain(this)
}

fun Should<Int>.beInRange(lower: Int, upper: Int): ShouldChain<Int> {
    expectation.toBeInRange(lower, upper)
    return ShouldChain(this)
}

fun Should<Int>.beApproximately(value: Int, tolerance: Int): ShouldChain<Int> {
    expectation.toBeApproximately(value, tolerance)
    return ShouldChain(this)
}
