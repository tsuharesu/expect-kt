/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations.tests

import kotlin.expectations.*
import kotlin.test.assertFailsWith
import org.junit.Test as test


class BooleanExpectationTests {
    @test fun toBeTrueTest() {
        expect(true).toBeTrue()

        assertFailsWith(AssertionError::class.java, {
            expect(false).toBeTrue()
        })

        true.should.beTrue()

        assertFailsWith(AssertionError::class.java, {
            false.should.beTrue()
        })
    }

    @test fun toBeFalseTest() {
        expect(false).toBeFalse()

        assertFailsWith(AssertionError::class.java, {
            expect(true).toBeFalse()
        })

        false.should.beFalse()

        assertFailsWith(AssertionError::class.java, {
            true.should.beFalse()
        })
    }
}