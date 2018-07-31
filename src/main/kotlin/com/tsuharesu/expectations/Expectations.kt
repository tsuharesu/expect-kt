/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.reflect.KClass
import kotlin.test.assertNull
import kotlin.test.assertTrue

// Entry points for expectations
fun <T> expect(target: T): Expectation<T> {
    return Expectation(target)
}

fun <T> expect(target: T, block: Expectation<T>.() -> Unit) {
    block(Expectation(target))
}

val <T> T.should: Should<T> get() = Should(this)

fun <T> T.should(block: Should<T>.() -> Unit) {
    block(Should(this))
}

// sugar
class ExpectationChain<T>(private val expectation: Expectation<T>) {
    val and: Expectation<T> get() = expectation
}

// add support for chaining
class ShouldChain<T>(val should: Should<T>) {
    val and: Should<T> get() = should
}

open class Expectation<T>(val target: T) {

    fun toBeNull(): ExpectationChain<T> {
        assertNull(target)
        return ExpectationChain(this)
    }

    fun toNotBeNull(): ExpectationChain<T> {
        assertTrue(target != null)
        return ExpectationChain(this)
    }

    fun toBe(test: T): ExpectationChain<T> {
        assertTrue(target == test, "expected <$target> to be <$test>")
        return ExpectationChain(this)
    }

    fun toBeInstanceOf(test: KClass<*>): ExpectationChain<T> {
        assertTrue(test.java.isInstance(target), "expected <$target> to be <$test>")
        return ExpectationChain(this)
    }

    fun toNotBe(test: T): ExpectationChain<T> {
        assertTrue(target != test)
        return ExpectationChain(this)
    }
}

// Shim around expectations
class Should<T>(target: T) {

    val expectation = Expectation(target)

    // NULLABLE TYPES
    fun beNull(): ShouldChain<T> {
        expectation.toBeNull()
        return ShouldChain(this)
    }

    fun notBeNull(): ShouldChain<T> {
        expectation.toNotBeNull()
        return ShouldChain(this)
    }

    fun be(test: T): ShouldChain<T> {
        expectation.toBe(test)
        return ShouldChain(this)
    }

    fun beInstanceOf(test: KClass<*>): ShouldChain<T> {
        expectation.toBeInstanceOf(test)
        return ShouldChain(this)
    }

    fun notBe(test: T): ShouldChain<T> {
        expectation.toNotBe(test)
        return ShouldChain(this)
    }
}