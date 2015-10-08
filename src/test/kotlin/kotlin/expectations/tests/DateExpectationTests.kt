/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations.tests

import java.util.Date
import kotlin.expectations.*
import kotlin.test.assertFailsWith
import org.junit.Test as test

class DateExpectationTests {
    @test fun toBeAfter() {
        val laterDate = Date(2001, 1, 1)
        val earlierDate = Date(2000, 1, 1)

        expect(laterDate).toBeAfter(earlierDate)
        assertFailsWith(AssertionError::class.java, {
            expect(earlierDate).toBeAfter(laterDate)
        })

        laterDate.should.beAfter(earlierDate)
        assertFailsWith(AssertionError::class.java, {
            earlierDate.should.beAfter(laterDate)
        })
    }

    @test fun toBeBefore() {
        val laterDate = Date(2001, 1, 1)
        val earlierDate = Date(2000, 1, 1)

        expect(earlierDate).toBeBefore(laterDate)
        assertFailsWith(AssertionError::class.java, {
            expect(laterDate).toBeBefore(earlierDate)
        })

        earlierDate.should.beBefore(laterDate)
        assertFailsWith(AssertionError::class.java, {
            laterDate.should.beBefore(earlierDate)
        })
    }

//    test fun toBeOnOrAfter() {
//        val currentDay = DateTime().toDate() as Date
//        val currentDayDifferentTime = DateTime().minusHours(1)?.toDate() as Date
//        val previousDay = DateTime().minusDays(1)?.toDate() as Date
//        val nextDay = DateTime().plusDays(1)?.toDate() as Date
//
//        expect(currentDay).toBeOnOrAfter(previousDay)
//        expect(currentDay).toBeOnOrAfter(currentDayDifferentTime)
//        failsWith(javaClass<AssertionError>()) {
//            expect(currentDay).toBeOnOrAfter(nextDay)
//        }
//    }
}