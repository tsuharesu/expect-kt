/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun Expectation<Double>.toBeGreaterOrEqualTo(value: Double): ExpectationChain<Double> {
    assertTrue(target >= value)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeGreaterThan(value: Double): ExpectationChain<Double> {
    assertTrue(target > value)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeLessOrEqualTo(value: Double): ExpectationChain<Double> {
    assertTrue(target <= value)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeLessThan(value: Double): ExpectationChain<Double> {
    assertTrue(target < value)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeInRange(lower: Double, upper: Double): ExpectationChain<Double> {
    assertTrue(target in lower..upper)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeApproximately(value: Double, tolerance: Double): ExpectationChain<Double> {
    return expect(target).toBeInRange(value - tolerance, value + tolerance)
}

val Double.should: Should<Double> get() = Should(this)

fun Should<Double>.beGreaterOrEqualTo(value: Double): ShouldChain<Double> {
    expector.toBeGreaterOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Double>.beGreaterThan(value: Double): ShouldChain<Double> {
    expector.toBeGreaterThan(value)
    return ShouldChain(this)
}

fun Should<Double>.beLessOrEqualTo(value: Double): ShouldChain<Double> {
    expector.toBeLessOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Double>.beLessThan(value: Double): ShouldChain<Double> {
    expector.toBeLessThan(value)
    return ShouldChain(this)
}

fun Should<Double>.beInRange(lower: Double, upper: Double): ShouldChain<Double> {
    expector.toBeInRange(lower, upper)
    return ShouldChain(this)
}

fun Should<Double>.beApproximately(value: Double, tolerance: Double): ShouldChain<Double> {
    expector.toBeApproximately(value, tolerance)
    return ShouldChain(this)
}
