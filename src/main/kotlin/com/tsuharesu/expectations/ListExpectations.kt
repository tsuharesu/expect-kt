/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.test.assertTrue

fun <T> Expectation<List<T>>.toBeEmpty(): ExpectationChain<List<T>> {
    assertTrue(target.isEmpty())
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotBeEmpty(): ExpectationChain<List<T>> {
    assertTrue(target.isNotEmpty())
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toHaveSize(value: Int): ExpectationChain<List<T>> {
    assertTrue(target.size == value)
    return ExpectationChain(this)
}

fun <T, E> Expectation<List<T>>.toHaveSameSizeAs(value: List<E>): ExpectationChain<List<T>> {
    assertTrue(target.size == value.size)
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toContain(value: T): ExpectationChain<List<T>> {
    assertTrue(target.contains(value))
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toMatchLambda(value: (T) -> Boolean): ExpectationChain<List<T>> {
    assertTrue(target.any(value))
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toOnlyContain(value: (T) -> Boolean): ExpectationChain<List<T>> {
    assertTrue(target.all(value))
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toContainAll(value: List<T>): ExpectationChain<List<T>> {
    assertTrue(target.containsAll(value))
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toContainNull(): ExpectationChain<List<T>> {
    assertTrue(target.any { it == null })
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotContain(value: T): ExpectationChain<List<T>> {
    assertTrue(!target.contains(value))
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotMatchLambda(value: (T) -> Boolean): ExpectationChain<List<T>> {
    assertTrue(target.none(value))
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotContainAny(value: List<T>): ExpectationChain<List<T>> {
    assertTrue(value.none { target.contains(it) })
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotContainNull(): ExpectationChain<List<T>> {
    assertTrue(target.none { it == null })
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toStartWith(value: T): ExpectationChain<List<T>> {
    assertTrue(target.first() == value)
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toEndWith(value: T): ExpectationChain<List<T>> {
    assertTrue(target.last() == value)
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toHaveItemAt(item: T, index: Int): ExpectationChain<List<T>> {
    assertTrue(target.get(index) == item)
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotContainDuplicates(): ExpectationChain<List<T>> {
    assertTrue(target.size == target.distinct().size)
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toBeSubsetOf(value: List<T>): ExpectationChain<List<T>> {
    assertTrue(value.containsAll(target))
    return ExpectationChain(this)
}

val <T> List<T>.should: Should<List<T>> get() = Should(this)

fun <T> Should<List<T>>.beEmpty(): ShouldChain<List<T>> {
    expector.toBeEmpty()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notBeEmpty(): ShouldChain<List<T>> {
    expector.toNotBeEmpty()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.haveSize(value: Int): ShouldChain<List<T>> {
    expector.toHaveSize(value)
    return ShouldChain(this)
}

fun <T, E> Should<List<T>>.haveSameSizeAs(value: List<E>): ShouldChain<List<T>> {
    expector.toHaveSameSizeAs(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.contain(value: T): ShouldChain<List<T>> {
    expector.toContain(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.matchLambda(value: (T) -> Boolean): ShouldChain<List<T>> {
    expector.toMatchLambda(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.onlyContain(value: (T) -> Boolean): ShouldChain<List<T>> {
    expector.toOnlyContain(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.containAll(value: List<T>): ShouldChain<List<T>> {
    expector.toContainAll(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.containNull(): ShouldChain<List<T>> {
    expector.toContainNull()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notContain(value: T): ShouldChain<List<T>> {
    expector.toNotContain(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notMatchLambda(value: (T) -> Boolean): ShouldChain<List<T>> {
    expector.toNotMatchLambda(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notContainAny(value: List<T>): ShouldChain<List<T>> {
    expector.toNotContainAny(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notContainNull(): ShouldChain<List<T>> {
    expector.toNotContainNull()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.startWith(value: T): ShouldChain<List<T>> {
    expector.toStartWith(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.endWith(value: T): ShouldChain<List<T>> {
    expector.toEndWith(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.haveItemAt(item: T, index: Int): ShouldChain<List<T>> {
    expector.toHaveItemAt(item, index)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notContainDuplicates(): ShouldChain<List<T>> {
    expector.toNotContainDuplicates()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.beSubsetOf(value: List<T>): ShouldChain<List<T>> {
    expector.toBeSubsetOf(value)
    return ShouldChain(this)
}