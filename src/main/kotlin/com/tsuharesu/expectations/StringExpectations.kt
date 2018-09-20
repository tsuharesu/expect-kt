/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun Expectation<String>.toBeEmpty(): ExpectationChain<String> {
    assertTrue(target.isEmpty(), "$target expected to be empty")
    return ExpectationChain(this)
}

fun Expectation<String>.toNotBeEmpty(): ExpectationChain<String> {
    assertTrue(target.isNotEmpty(), "expected to not be empty")
    return ExpectationChain(this)
}

fun Expectation<String>.toHaveLengthOf(length: Int): ExpectationChain<String> {
    assertTrue(target.length == length, "expected to have length $length but have length ${target.length}")
    return ExpectationChain(this)
}

fun Expectation<String>.toBeBlank(): ExpectationChain<String> {
    assertTrue(target.isBlank(), "$target expected to be blank")
    return ExpectationChain(this)
}

fun Expectation<String>.toNotBeBlank(): ExpectationChain<String> {
    assertTrue(target.isNotBlank(), "expected to not be blank")
    return ExpectationChain(this)
}

fun Expectation<String>.toBeEquivalentTo(value: String): ExpectationChain<String> {
    assertTrue(target.equals(value, ignoreCase = true), "$target expected to be equivalent to $value")
    return ExpectationChain(this)
}

fun Expectation<String>.toStartWith(value: String): ExpectationChain<String> {
    assertTrue(target.startsWith(value), "$target expected to start with $value")
    return ExpectationChain(this)
}

fun Expectation<String>.toStartWithEquivalent(value: String): ExpectationChain<String> {
    assertTrue(target.startsWith(value, ignoreCase = true), "$target expected to start with equivalent to $value")
    return ExpectationChain(this)
}

fun Expectation<String>.toEndWith(value: String): ExpectationChain<String> {
    assertTrue((target).endsWith(value), "$target expected to end with $value")
    return ExpectationChain(this)
}

fun Expectation<String>.toEndWithEquivalent(value: String): ExpectationChain<String> {
    assertTrue(target.endsWith(value, ignoreCase = true), "$target expected to end with equivalent to $value")
    return ExpectationChain(this)
}

fun Expectation<String>.toContain(value: String): ExpectationChain<String> {
    assertTrue(target.contains(value), "$target expected to contain $value")
    return ExpectationChain(this)
}

fun Expectation<String>.toContainEquivalent(value: String): ExpectationChain<String> {
    assertTrue(target.contains(value, ignoreCase = true), "$target expected to contain equivalent to $value")
    return ExpectationChain(this)
}

fun Expectation<String>.toNotContain(value: String): ExpectationChain<String> {
    assertTrue(!target.contains(value), "$target expected to not contain $value")
    return ExpectationChain(this)
}

fun Expectation<String>.toNotContainEquivalent(value: String): ExpectationChain<String> {
    assertTrue(!target.contains(value, ignoreCase = true), "$target expected to not contain equivalent to $value")
    return ExpectationChain(this)
}

fun Expectation<String>.toMatch(value: Regex): ExpectationChain<String> {
    assertTrue(target.matches(value), "$target expected to match $value")
    return ExpectationChain(this)
}

val String.should: Should<String> get() = Should(this)

fun Should<String>.beEmpty(): ShouldChain<String> {
    expectation.toBeEmpty()
    return ShouldChain(this)
}

fun Should<String>.notBeEmpty(): ShouldChain<String> {
    expectation.toNotBeEmpty()
    return ShouldChain(this)
}

fun Should<String>.haveLengthOf(length: Int): ShouldChain<String> {
    expectation.toHaveLengthOf(length)
    return ShouldChain(this)
}

fun Should<String>.beBlank(): ShouldChain<String> {
    expectation.toBeBlank()
    return ShouldChain(this)
}

fun Should<String>.notBeBlank(): ShouldChain<String> {
    expectation.toNotBeBlank()
    return ShouldChain(this)
}

fun Should<String>.beEquivalentTo(value: String): ShouldChain<String> {
    expectation.toBeEquivalentTo(value)
    return ShouldChain(this)
}

fun Should<String>.endWith(value: String): ShouldChain<String> {
    expectation.toEndWith(value)
    return ShouldChain(this)
}

fun Should<String>.endWithEquivalent(value: String): ShouldChain<String> {
    expectation.toEndWithEquivalent(value)
    return ShouldChain(this)
}

fun Should<String>.contain(value: String): ShouldChain<String> {
    expectation.toContain(value)
    return ShouldChain(this)
}

fun Should<String>.containEquivalent(value: String): ShouldChain<String> {
    expectation.toContainEquivalent(value)
    return ShouldChain(this)
}

fun Should<String>.notContain(value: String): ShouldChain<String> {
    expectation.toNotContain(value)
    return ShouldChain(this)
}

fun Should<String>.notContainEquivalent(value: String): ShouldChain<String> {
    expectation.toNotContainEquivalent(value)
    return ShouldChain(this)
}

fun Should<String>.startWith(value: String): ShouldChain<String> {
    expectation.toStartWith(value)
    return ShouldChain(this)
}

fun Should<String>.startWithEquivalent(value: String): ShouldChain<String> {
    expectation.toStartWithEquivalent(value)
    return ShouldChain(this)
}

fun Should<String>.match(value: Regex): ShouldChain<String> {
    expectation.toMatch(value)
    return ShouldChain(this)
}