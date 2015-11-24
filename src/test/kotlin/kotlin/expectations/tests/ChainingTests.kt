/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations.tests

import kotlin.expectations.*
import kotlin.test.assertFailsWith
import org.junit.Test as test


class ChainingTests {
    @test fun And() {
        expect("james").toStartWith("j").and.toEndWith("s")

        assertFailsWith(AssertionError::class.java, {
            expect("james").toStartWith("j").and.toEndWith("f")
        })

        assertFailsWith(AssertionError::class.java, {
            expect("james").toStartWith("f").and.toEndWith("s")
        })
    }

    @test fun shouldAnd() {
        "james".should.startWith("j").and.endWith("s")

        assertFailsWith(AssertionError::class.java, {
            "james".should.startWith("j").and.endWith("f")
        })

        assertFailsWith(AssertionError::class.java, {
            "james".should.startWith("f").and.endWith("s")
        })
    }
}