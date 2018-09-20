/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Tsuharesu Luciel
 */

package com.tsuharesu.expectations

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

private data class User(val name: String, val age: Int)

private fun Expectation<User>.toBeCalled(value: String): ExpectationChain<User> {
    assertEquals(target.name, value)
    return ExpectationChain(this)
}

private fun Expectation<User>.toBeOlderThan(otherUser: User): ExpectationChain<User> {
    assertTrue(target.age > otherUser.age)
    return ExpectationChain(this)
}

class CustomExpectationTests {
    private val user = User("Tsu", 27)
    private val olderUser = User("Tsu", 30)

    @Test
    fun toBeCalled() {
        expect(user).toBeCalled("Tsu")

        assertFailsWith(AssertionError::class) {
            expect(user).toBeCalled("Tzu")
        }
    }

    @Test
    fun toBeOlderThan() {
        expect(olderUser).toBeOlderThan(user)

        assertFailsWith(AssertionError::class) {
            expect(user).toBeOlderThan(olderUser)
        }
    }
}