/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.reflect.KClass
import kotlin.test.assertTrue

fun <T> Expectation<List<T>>.toBeEmpty(): ExpectationChain<List<T>> {
    assertTrue(target.isEmpty(), "list with size ${target.size} expected to be empty")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotBeEmpty(): ExpectationChain<List<T>> {
    assertTrue(target.isNotEmpty(), "list expected to not be empty")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toHaveSize(value: Int): ExpectationChain<List<T>> {
    assertTrue(target.size == value, "list with size ${target.size} expected to have size $value")
    return ExpectationChain(this)
}

fun <T, E> Expectation<List<T>>.toHaveSameSizeAs(value: List<E>): ExpectationChain<List<T>> {
    return toHaveSize(value.size)
}

fun <T> Expectation<List<T>>.toContain(value: T): ExpectationChain<List<T>> {
    assertTrue(target.contains(value), "$target expected to contain $value")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toContainAll(value: List<T>): ExpectationChain<List<T>> {
    assertTrue(target.containsAll(value), "$target expected to contain $value")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toContainNull(): ExpectationChain<List<T>> {
    assertTrue(target.any { it == null }, "$target expected to contain null")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotContainNull(): ExpectationChain<List<T>> {
    assertTrue(target.none { it == null }, "$target expected to not contain null")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotContain(value: T): ExpectationChain<List<T>> {
    assertTrue(!target.contains(value), "$target expected to not contain $value")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotContainAny(value: List<T>): ExpectationChain<List<T>> {
    assertTrue(value.none { target.contains(it) }, "$target expected to not contain any item of list $value")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.anyToMatchLambda(value: (T) -> Boolean): ExpectationChain<List<T>> {
    assertTrue(target.any(value), "expected to find any item matching the lambda")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.allToMatchLambda(value: (T) -> Boolean): ExpectationChain<List<T>> {
    assertTrue(target.all(value), "expected all items to match the lambda")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.noneToMatchLambda(value: (T) -> Boolean): ExpectationChain<List<T>> {
    assertTrue(target.none(value), "expected that no items matched the lambda")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toStartWith(value: T): ExpectationChain<List<T>> {
    assertTrue(target.first() == value, "expected to start with $value")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toEndWith(value: T): ExpectationChain<List<T>> {
    assertTrue(target.last() == value, "expected to end with $value")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toHaveItemAt(item: T, index: Int): ExpectationChain<List<T>> {
    assertTrue(target[index] == item, "expected to have item $item at index $index")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toHaveInstanceOfItemAt(
    value: KClass<*>,
    index: Int
): ExpectationChain<List<T>> {
    assertTrue(
        value.java.isInstance(target[index]),
        "${target[index]} expected to be instance of ${value.java.simpleName}"
    )
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toNotContainDuplicates(): ExpectationChain<List<T>> {
    assertTrue(target.size == target.distinct().size, "expected to not contain duplicates")
    return ExpectationChain(this)
}

fun <T> Expectation<List<T>>.toBeSubsetOf(value: List<T>): ExpectationChain<List<T>> {
    assertTrue(value.containsAll(target), "expected to be a subset of $value")
    return ExpectationChain(this)
}

val <T> List<T>.should: Should<List<T>> get() = Should(this)

fun <T> Should<List<T>>.beEmpty(): ShouldChain<List<T>> {
    expectation.toBeEmpty()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notBeEmpty(): ShouldChain<List<T>> {
    expectation.toNotBeEmpty()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.haveSize(value: Int): ShouldChain<List<T>> {
    expectation.toHaveSize(value)
    return ShouldChain(this)
}

fun <T, E> Should<List<T>>.haveSameSizeAs(value: List<E>): ShouldChain<List<T>> {
    expectation.toHaveSameSizeAs(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.contain(value: T): ShouldChain<List<T>> {
    expectation.toContain(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.haveInstanceOfItemAt(item: KClass<*>, index: Int): ShouldChain<List<T>> {
    expectation.toHaveInstanceOfItemAt(item, index)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.anyMatchLambda(value: (T) -> Boolean): ShouldChain<List<T>> {
    expectation.anyToMatchLambda(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.allMatchLambda(value: (T) -> Boolean): ShouldChain<List<T>> {
    expectation.allToMatchLambda(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.containAll(value: List<T>): ShouldChain<List<T>> {
    expectation.toContainAll(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.containNull(): ShouldChain<List<T>> {
    expectation.toContainNull()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notContain(value: T): ShouldChain<List<T>> {
    expectation.toNotContain(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.noneMatchLambda(value: (T) -> Boolean): ShouldChain<List<T>> {
    expectation.noneToMatchLambda(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notContainAny(value: List<T>): ShouldChain<List<T>> {
    expectation.toNotContainAny(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notContainNull(): ShouldChain<List<T>> {
    expectation.toNotContainNull()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.startWith(value: T): ShouldChain<List<T>> {
    expectation.toStartWith(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.endWith(value: T): ShouldChain<List<T>> {
    expectation.toEndWith(value)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.haveItemAt(item: T, index: Int): ShouldChain<List<T>> {
    expectation.toHaveItemAt(item, index)
    return ShouldChain(this)
}

fun <T> Should<List<T>>.notContainDuplicates(): ShouldChain<List<T>> {
    expectation.toNotContainDuplicates()
    return ShouldChain(this)
}

fun <T> Should<List<T>>.beSubsetOf(value: List<T>): ShouldChain<List<T>> {
    expectation.toBeSubsetOf(value)
    return ShouldChain(this)
}