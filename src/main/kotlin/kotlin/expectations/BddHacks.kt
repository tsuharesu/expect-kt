/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */

package kotlin.expectations

// cheap hacks for heroes!
public fun describe(description: String, block: () -> Unit) {
    println(description); block()
}

public fun it(description: String, block: () -> Unit) {
    try {
        block()
        println("\t $description - ✔")
    } catch(e: Error) {
        println("\t $description - ✘")
        throw e
    }
}