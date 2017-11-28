# expect-kt
[![CircleCI](https://circleci.com/gh/tsuharesu/expect-kt.svg?style=svg)](https://circleci.com/gh/tsuharesu/expect-kt) [![Release](https://img.shields.io/github/tag/tsuharesu/expect-kt.svg?label=maven)](https://jitpack.io/#tsuharesu/expect-kt) [![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

expect-kt is a set of fluent assertions for Kotlin, for a better readability of your code than using `kotlin.test`. Each type has a set of extension functions that allow you to check certain specifics that relate to that type.

This project is a fork of https://github.com/kouphax/expect.kt. That project was kind of abandoned (since 2012 without commits) and lacking a way to use with Gradle/maven. I just updated it so I can use on some projects, and hope to improve some areas and add new features (like better messages and new extensions).

This is too a way for me to understand [Kotlin](http://kotlinlang.org/) and explore its features. The original project was inspired by [FluentAssertions for .NET](http://fluentassertions.com/) and now I'm inpired by [AssertJ](http://joel-costigliola.github.io/assertj/) too.

# How to add to project

Add Jitpack to the list of project repositories

```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

Then add `expect-kt` as a project dependency

```groovy
dependencies {
    testImplementation 'com.github.tsuharesu:expect-kt:0.7.1'
}
```

# Syntax

expect-kt allows you to use two different approaches to define an assertion:

## Expect Syntax

Expect syntax offers typical `expect(something).toBeInACertainState` style of grammar that everybody uses. Like this:
```java
expect("james").toBe("james")
```

## Fluent Syntax

It is also possible to use a more fluent syntax (some kind of BDD) to make the same assertion
```java
"james".should.be("james")
```

# Chaining

expect-kt allows you to chain assertions to keep things really neat and tidy.
```java
expect("james").toStartWith("j").and.toEndWith("s")
```

Or, in fluent syntax
```java
"james".should.startWith("j").and.endWith("s")
```

# Standard Assertions

There are a few assertions that can be used on any type

## toBe/be

Assert that the value should be equal to the other
```java
expect("james").toBe("james")
"james".should.be("james")
```

## toNotBe/notBe

Assert that the value should NOT be equal the other
```java
expect("james").toNotBe("jaime")
"james".should.notBe("jaime")
```

## toBeNull/beNull

Assert that the value is null
```java
expect(null).toBeNull()
null.should.beNull()
```

## toNotBeNull/notBeNull

Assert that the value is NOT null
```java
expect("james").toNotBeNull()
"james".should.notBeNull()
```

# Logic Assertions

## toBeTrue/beTrue

Assert that the value is `true`
```java
expect(true).toBeTrue()
true.should.beTrue()
```

## toNotBeTrue/notBeTrue

Assert that the value is NOT `true`
```java
expect(false).toNotBeTrue()
false.should.notBeTrue()
```

## toBeFalse/beFalse

Assert that the value is `false`
```java
expect(false).toBeFalse()
false.should.beFalse()
```

## toNotBeFalse/notBeFalse

Assert that the value is NOT `false`
```java
expect(true).toNotBeFalse()
true.should.notBeFalse()
```

# String Assertions

## toBeEmpty/beEmpty

Assert that a string is empty ("")
```java
expect("").toBeEmpty()
"".should.beEmpty()
```

## toNotBeEmpty/beNotEmpty

Assert that a string is NOT empty ("")
```java
expect("  ").toNotBeEmpty()
"  ".should.beNotEmpty()
```

## toHaveLength/haveLength

Assert that a string is of a certain length
```java
expect("james").toHaveLength(5)
"james".should.haveLength(5)
```

## toBeBlank/beBlank

Assert that a string is blank, in that it is empty or contains only whitespace
```java
expect("   ").toBeBlank()
"    ".should.beBlank()
```

## toNotBeBlank/notBeBlank

Assert that a string is not blank, in that it isn't empty or contains more than whitespace
```java
expect("james").toNotBeBlank()
"james".should.notBeBlank()
```

## toBeEquivalentTo/beEquivalentTo

Assert that a string is equal to another string regardless of case (ignore case comparation)
```
expect("JAMES").toBeEquivalentTo("james")
"JAMES".should.beEquivalentTo("james")
```

## toEndWith/endWith

Assert that a string ends with another string
```java
expect("James").toEndWith("es")
"James".should.endWith("es")
```

## toEndWithEquivalent/endWithEquivalent

Assert that a string ends with another string regardless of case
```java
expect("JAMES").toEndWithEquivalent("es")
"JAMES".should.endWithEquivalent("es")
```

## toContain/contain

Assert that a string contains another string
```java
expect("james").toContain("am")
"james".should.contain("am")
```

## toContainEquivalent/containEquivalent

Assert that a string contains another string regardless of case.
```java
expect("JAMES").toContainEquivalent("am")
"JAMES".should.containEquivalent("am")
```

## toNotContain/notContain

Assert that a string doesn't contain another string.
```java
expect("james").toNotContain("ei")
"james".should.notContain("ei")
```

## toNotContainEquivalent/notContainEquivalent

Assert that a string doesn't contain another string regardless of case.
```java
expect("JAMES").toNotContainEquivalent("ei")
"JAMES".should.notContainEquivalent("ei")
```

## toStartWith/startWith

Assert that a string starts with another string.
```java
expect("james").toStartWith("j")
"james".should.startWith("j")
```

## toStartWithEquivalent/startWithEquivalent

Assert that a string starts with another string regardless of case.
```java
expect("james").toStartWithEquivalent("JA")
"james".should.startWithEquivalent("JA")
```

## toMatch/match

Assert that a string matches the given regex.
```java
expect("james").toMatch("^james$")
"james".should.match("^james$")
```

# Numeric Assertions (currently Int, Long, Double, Float)

## toBeGreaterOrEqualTo/beGreaterOrEqualTo

Assert that a number is greater than or equal to another
```java
expect(2).toBeGreaterOrEqualTo(1)
2.should.beGreaterOrEqualTo(1)
```

## toBeGreaterThan/beGreaterThan

Assert that a number is greater than to another
```java
expect(2).toBeGreaterThan(1)
2.should.beGreaterThan(1)
```

## toBeLessOrEqualTo/beLessOrEqualTo

Assert that a number is less than or equal to another
```java
expect(1).toBeLessOrEqualTo(2)
1.should.beLessOrEqualTo(2)
```

## toBeLessThan/beLessThan

Assert that a number is less than to another
```java
expect(1).toBeLessThan(2)
1.should.beLessThan(2)
```

## toBeInRange/beInRange

Assert that a number is within the lower and upper bounds passed in
```java
expect(2).toBeInRange(1, 3)
2.should.beInRange(1, 3)
```

## toBeApproximately/beApproximately

Assert that a number is approximately another - the level of error is defined by the tolerance value (+/- tolerance)
```java
expect(2f).toBeApproximately(2.1f, 0.1f)
2f.should.beApproximately(2.1f, 0.1f)
```

# Collection Assertions (currently List)

## toBeEmpty

Assert that the list don't have any items
```java
expect(listOf<String>()).toBeEmpty()
listOf<String>().should.beEmpty()
```

## toNotBeEmpty

Assert that the list contain items
```java
expect(listOf("james")).toNotBeEmpty()
listOf("james").should.notBeEmpty()
```

## toHaveSize

Assert that the list contains x items
```java
expect(listOf("james", "cindy")).toHaveSize(2)
listOf("james", "cindy").should.haveSize(2)
```

## toHaveSameSizeAs

Assert that the list contains the same of items as other list (same type or not)
```java
expect(listOf("james", "cindy")).toHaveSameSizeAs(listOf(1, 2))
listOf("james", "cindy").should.haveSameSizeAs(listOf(1, 2))
```

## toContain

Assert that the list contains this item
```java
expect(listOf("james", "cindy")).toContain("james")
listOf("james", "cindy").should.contain("james")
```

## toMatchLambda

Assert that the list contains any item that matches the lambda (predicate)
```java
expect(listOf(1, 2)).toContain { it > 1 }
listOf(1, 2).should.contain { it > 1 }
```

## toContainAll

Assert that the list contains all this items
```java
expect(listOf("james", "cindy")).toContainAll(listOf("james"))
listOf("james", "cindy").should.containAll(listOf("james"))
```

## toOnlyContain

Assert that all items in the list matches the lambda (predicate)
expect(listOf(2, 4, 6)).toOnlyContain { it.mod(2) == 0 }
listOf(2, 4, 6).should.onlyContain { it.mod(2) == 0 }

## toContainNull

Assert that the list contains a null value
```java
expect(listOf("james", null)).toContainNull()
listOf("james", null).should.containNull()
```

## toNotContain

Assert that the list does not contain this item
```java
expect(listOf("james", "cindy")).toNotContain("tsu")
listOf("james", "cindy").should.notContain("tsu")
```

## toNotMatchLambda

Assert that the list does not have any item that matches the lambda (predicate)
```java
expect(listOf(1, 2)).toNotContain { it > 2 }
listOf(1, 2).should.notContain { it > 2 }
```

## toNotContainAny

Assert that the list does not contain any of this items
```java
expect(listOf("james", "cindy")).toNotContainAny(listOf("tsu"))
listOf("james", "cindy").should.notContainAny(listOf("tsu"))
```

## toNotContainNull

Assert that the list does not contain null
```java
expect(listOf("james", "cindy")).toNotContainNull()
listOf("james", "cindy").should.notContainNull()
```

## toStartWith

Assert that the list first item is this
```java
expect(listOf("james", "cindy")).toStartWith("james")
listOf("james", "cindy").should.startWith("james")
```

## toEndWith

Assert that the list last item is this
```java
expect(listOf("james", "cindy")).toEndWith("cindy")
listOf("james", "cindy").should.endWith("cindy")
```

## toHaveItemAt

Assert that the list have a specific item at a position
```java
expect(listOf("james", "cindy")).toHaveItemAt("cindy", 1)
listOf("james", "cindy").should.haveItemAt("cindy", 1)
```

## toNotContainDuplicates

Assert that the list does not contains duplicated items
```java
expect(listOf("james", "cindy")).toNotContainDuplicates()
listOf("james", "cindy").should.notContainDuplicates()
```

## toBeSubsetOf

Assert that this list is a subset of another list
```java
expect(listOf("james", "cindy")).toBeSubsetOf(listOf("james", "cindy", "tsu", "aphrodite"))
listOf("james", "cindy").should.beSubsetOf(listOf("james", "cindy", "tsu", "aphrodite"))
```


<!--
> TODO: This stuff is still in development and very subject to change.

# Dictionary Assertions

## toEqual
## toNotEqual
## toBeEmpty
## toNotBeEmpty
## toContainKey
## toNotContainKey
## toContainValue
## toNotContainValue
## toHaveCount
## toContain - keyvaluepair

# Exception Assertions

## toThrow
## toThrow&lt;TException>
## toNotThrow
## toNotThrow&lt;TException>

-->
