/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun Expectation<Float>.toBeGreaterOrEqualTo(value: Float): ExpectationChain<Float> {
    assertTrue(target >= value)
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeGreaterThan(value: Float): ExpectationChain<Float> {
    assertTrue(target > value)
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeLessOrEqualTo(value: Float): ExpectationChain<Float> {
    assertTrue(target <= value)
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeLessThan(value: Float): ExpectationChain<Float> {
    assertTrue(target < value)
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeInRange(lower: Float, upper: Float): ExpectationChain<Float> {
    assertTrue(target >= lower && target <= upper)
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeApproximately(value: Float, tolerance: Float): ExpectationChain<Float> {
    return expect(target).toBeInRange(value - tolerance, value + tolerance)
}

val Float.should: Should<Float> get() = Should(this)

fun Should<Float>.beGreaterOrEqualTo(value: Float): ShouldChain<Float> {
    expector.toBeGreaterOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Float>.beGreaterThan(value: Float): ShouldChain<Float> {
    expector.toBeGreaterThan(value)
    return ShouldChain(this)
}

fun Should<Float>.beLessOrEqualTo(value: Float): ShouldChain<Float> {
    expector.toBeLessOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Float>.beLessThan(value: Float): ShouldChain<Float> {
    expector.toBeLessThan(value)
    return ShouldChain(this)
}

fun Should<Float>.beInRange(lower: Float, upper: Float): ShouldChain<Float> {
    expector.toBeInRange(lower, upper)
    return ShouldChain(this)
}

fun Should<Float>.beApproximately(value: Float, tolerance: Float): ShouldChain<Float> {
    expector.toBeApproximately(value, tolerance)
    return ShouldChain(this)
}
