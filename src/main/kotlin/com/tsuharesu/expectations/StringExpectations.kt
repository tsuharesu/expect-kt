/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun Expectation<String>.toBeEmpty(): ExpectationChain<String> {
    assertTrue(target == "")
    return ExpectationChain(this)
}

fun Expectation<String>.toNotBeEmpty(): ExpectationChain<String> {
    assertTrue(target != "")
    return ExpectationChain(this)
}

fun Expectation<String>.toHaveLengthOf(length: Int): ExpectationChain<String> {
    assertTrue(target.length == length)
    return ExpectationChain(this)
}

fun Expectation<String>.toBeBlank(): ExpectationChain<String> {
    assertTrue(target.trim() == "")
    return ExpectationChain(this)
}

fun Expectation<String>.toNotBeBlank(): ExpectationChain<String> {
    assertTrue(target.trim() != "")
    return ExpectationChain(this)
}

fun Expectation<String>.toBeEquivalentTo(comparison: String): ExpectationChain<String> {
    assertTrue((target).equals(comparison, ignoreCase = true))
    return ExpectationChain(this)
}

fun Expectation<String>.toEndWith(comparison: String): ExpectationChain<String> {
    assertTrue((target).endsWith(comparison))
    return ExpectationChain(this)
}

fun Expectation<String>.toEndWithEquivalent(comparison: String): ExpectationChain<String> {
    assertTrue((target).toLowerCase().endsWith(comparison.toLowerCase()))
    return ExpectationChain(this)
}

fun Expectation<String>.toContain(comparison: String): ExpectationChain<String> {
    assertTrue((target).indexOf(comparison) > -1)
    return ExpectationChain(this)
}

fun Expectation<String>.toContainEquivalent(comparison: String): ExpectationChain<String> {
    assertTrue((target).toLowerCase().indexOf(comparison.toLowerCase()) > -1)
    return ExpectationChain(this)
}

fun Expectation<String>.toNotContain(comparison: String): ExpectationChain<String> {
    assertTrue((target).indexOf(comparison) == -1)
    return ExpectationChain(this)
}

fun Expectation<String>.toNotContainEquivalent(comparison: String): ExpectationChain<String> {
    assertTrue((target).toLowerCase().indexOf(comparison.toLowerCase()) == -1)
    return ExpectationChain(this)
}

fun Expectation<String>.toStartWith(comparison: String): ExpectationChain<String> {
    assertTrue((target).startsWith(comparison))
    return ExpectationChain(this)
}

fun Expectation<String>.toStartWithEquivalent(comparison: String): ExpectationChain<String> {
    assertTrue((target).toLowerCase().startsWith(comparison.toLowerCase()))
    return ExpectationChain(this)
}

fun Expectation<String>.toMatch(regex: String): ExpectationChain<String> {
    assertTrue((target).matches(regex.toRegex()))
    return ExpectationChain(this)
}

val String.should: Should<String> get() = Should(this)

fun Should<String>.beEmpty(): ShouldChain<String> {
    expector.toBeEmpty()
    return ShouldChain(this)
}

fun Should<String>.notBeEmpty(): ShouldChain<String> {
    expector.toNotBeEmpty()
    return ShouldChain(this)
}

fun Should<String>.haveLengthOf(length: Int): ShouldChain<String> {
    expector.toHaveLengthOf(length)
    return ShouldChain(this)
}

fun Should<String>.beBlank(): ShouldChain<String> {
    expector.toBeBlank()
    return ShouldChain(this)
}

fun Should<String>.notBeBlank(): ShouldChain<String> {
    expector.toNotBeBlank()
    return ShouldChain(this)
}

fun Should<String>.beEquivalentTo(comparison: String): ShouldChain<String> {
    expector.toBeEquivalentTo(comparison)
    return ShouldChain(this)
}

fun Should<String>.endWith(comparison: String): ShouldChain<String> {
    expector.toEndWith(comparison)
    return ShouldChain(this)
}

fun Should<String>.endWithEquivalent(comparison: String): ShouldChain<String> {
    expector.toEndWithEquivalent(comparison)
    return ShouldChain(this)
}

fun Should<String>.contain(comparison: String): ShouldChain<String> {
    expector.toContain(comparison)
    return ShouldChain(this)
}

fun Should<String>.containEquivalent(comparison: String): ShouldChain<String> {
    expector.toContainEquivalent(comparison)
    return ShouldChain(this)
}

fun Should<String>.notContain(comparison: String): ShouldChain<String> {
    expector.toNotContain(comparison)
    return ShouldChain(this)
}

fun Should<String>.notContainEquivalent(comparison: String): ShouldChain<String> {
    expector.toNotContainEquivalent(comparison)
    return ShouldChain(this)
}

fun Should<String>.startWith(comparison: String): ShouldChain<String> {
    expector.toStartWith(comparison)
    return ShouldChain(this)
}

fun Should<String>.startWithEquivalent(comparison: String): ShouldChain<String> {
    expector.toStartWithEquivalent(comparison)
    return ShouldChain(this)
}

fun Should<String>.match(regex: String): ShouldChain<String> {
    expector.toMatch(regex)
    return ShouldChain(this)
}