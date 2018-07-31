/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun Expectation<Boolean>.toBeTrue(): ExpectationChain<Boolean> {
    assertTrue(target)
    return ExpectationChain(this)
}

fun Expectation<Boolean>.toBeFalse(): ExpectationChain<Boolean> {
    assertTrue(!target)
    return ExpectationChain(this)
}

val Boolean.should: Should<Boolean> get() = Should(this)

fun Should<Boolean>.beTrue(): ShouldChain<Boolean> {
    expectation.toBeTrue()
    return ShouldChain(this)
}

fun Should<Boolean>.beFalse(): ShouldChain<Boolean> {
    expectation.toBeFalse()
    return ShouldChain(this)
}
