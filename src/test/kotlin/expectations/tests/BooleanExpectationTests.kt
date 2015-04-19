/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations.tests

import kotlin.expectations.*
import kotlin.test.failsWith
import org.junit.Test as test


class BooleanExpectationTests {
    test fun toBeTrueTest() {
        expect(true).toBeTrue()

        failsWith(javaClass<AssertionError>()) {
            expect(false).toBeTrue()
        }

        true.should.beTrue()

        failsWith(javaClass<AssertionError>()) {
            false.should.beTrue()
        }
    }

    test fun toBeFalseTest() {
        expect(false).toBeFalse()

        failsWith(javaClass<AssertionError>()) {
            expect(true).toBeFalse()
        }

        false.should.beFalse()

        failsWith(javaClass<AssertionError>()) {
            true.should.beFalse()
        }
    }
}