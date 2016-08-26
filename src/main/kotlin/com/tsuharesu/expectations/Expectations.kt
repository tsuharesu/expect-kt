/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

// Entry points for expectations
fun <T> expect(target: T): Expectation<T> {
    return Expectation(target)
}


val <T> T.should: Should<T> get() = Should(this)

// sugar
class ExpectationChain<T>(val expectation: Expectation<T>) {
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
        assert(target != null)
        return ExpectationChain(this)
    }

    fun toBe(test: T): ExpectationChain<T> {
        assert(target == test) { "expected <$target> to be <$test>" }
        return ExpectationChain(this)
    }

    fun toNotBe(test: T): ExpectationChain<T> {
        assertTrue(target != test)
        return ExpectationChain(this)
    }
}


// Shim around expectations
class Should<T>(val target: T) {

    val expector = Expectation(target)

    // NULLABLE TYPES
    fun beNull(): ShouldChain<T> {
        expector.toBeNull()
        return ShouldChain(this)
    }

    fun notBeNull(): ShouldChain<T> {
        expector.toNotBeNull()
        return ShouldChain(this)
    }

    fun be(test: T): ShouldChain<T> {
        expector.toBe(test)
        return ShouldChain(this)
    }

    fun notBe(test: T): ShouldChain<T> {
        expector.toNotBe(test)
        return ShouldChain(this)
    }
}