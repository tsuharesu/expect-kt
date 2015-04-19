package kotlin.expectations

import java.util.Date
import kotlin.test.assertTrue

fun Expectation<Date>.toBeAfter(date: Date): ExpectationChain<Date> {
    assertTrue(target.after(date))
    return ExpectationChain(this)
}

fun Expectation<Date>.toBeBefore(date: Date): ExpectationChain<Date> {
    assertTrue(target.before(date))
    return ExpectationChain(this)
}

public val Date.should: Should<Date> get() = Should(this)

fun Should<Date>.beAfter(date: Date): ShouldChain<Date> {
    expector.toBeAfter(date)
    return ShouldChain(this)
}

fun Should<Date>.beBefore(date: Date): ShouldChain<Date> {
    expector.toBeBefore(date)
    return ShouldChain(this)
}

//fun Expectation<Date>.toBeOnOrAfter(date: Date): ExpectationChain<Date> {
//    val targetJoda = DateTime(target).toLocalDate()
//    val dateJoda = DateTime(date).toLocalDate()
//    expect(targetJoda?.compareTo(dateJoda) as Int).toBeInRange(0, 1)
//    return ExpectationChain(this)
//}

//fun Should<Date>.beOnOrAfter(date: Date): ShouldChain<Date> {
//    expector.toBeOnOrAfter(date)
//    return ShouldChain(this)
//}

// TODO: verify some way to do this without using JodaTime