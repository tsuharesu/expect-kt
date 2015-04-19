/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations.tests

import kotlin.expectations.expect
import kotlin.expectations.toEndWith
import kotlin.expectations.toStartWith
import kotlin.test.failsWith
import org.junit.Test as test


class ChainingTests {
    test fun And() {
        expect("james").toStartWith("j").and.toEndWith("s")

        failsWith(javaClass<AssertionError>()) {
            expect("james").toStartWith("j").and.toEndWith("f")
        }

        failsWith(javaClass<AssertionError>()) {
            expect("james").toStartWith("f").and.toEndWith("s")
        }
    }
}