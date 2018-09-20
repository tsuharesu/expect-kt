/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Tsuharesu
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun Expectation<Float>.toBeGreaterOrEqualTo(value: Float): ExpectationChain<Float> {
    assertTrue(target >= value, "$target expected to be greater than or equal to $value")
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeGreaterThan(value: Float): ExpectationChain<Float> {
    assertTrue(target > value, "$target expected to be greater than $value")
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeLessOrEqualTo(value: Float): ExpectationChain<Float> {
    assertTrue(target <= value, "$target expected to be less than or equal to $value")
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeLessThan(value: Float): ExpectationChain<Float> {
    assertTrue(target < value, "$target expected to be less than $value")
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeInRange(lower: Float, upper: Float): ExpectationChain<Float> {
    assertTrue(target in lower..upper, "$target expected to be between $lower and $upper")
    return ExpectationChain(this)
}

fun Expectation<Float>.toBeApproximately(value: Float, tolerance: Float): ExpectationChain<Float> {
    return expect(target).toBeInRange(value - tolerance, value + tolerance)
}

val Float.should: Should<Float> get() = Should(this)

fun Should<Float>.beGreaterOrEqualTo(value: Float): ShouldChain<Float> {
    expectation.toBeGreaterOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Float>.beGreaterThan(value: Float): ShouldChain<Float> {
    expectation.toBeGreaterThan(value)
    return ShouldChain(this)
}

fun Should<Float>.beLessOrEqualTo(value: Float): ShouldChain<Float> {
    expectation.toBeLessOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Float>.beLessThan(value: Float): ShouldChain<Float> {
    expectation.toBeLessThan(value)
    return ShouldChain(this)
}

fun Should<Float>.beInRange(lower: Float, upper: Float): ShouldChain<Float> {
    expectation.toBeInRange(lower, upper)
    return ShouldChain(this)
}

fun Should<Float>.beApproximately(value: Float, tolerance: Float): ShouldChain<Float> {
    expectation.toBeApproximately(value, tolerance)
    return ShouldChain(this)
}
