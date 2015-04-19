package kotlin.expectations.tests

import kotlin.expectations.expect
import kotlin.expectations.should
import kotlin.test.failsWith
import org.junit.Test as test


class GenericExpectationTests {
    test fun toBe() {
        expect("james").toBe("james")

        failsWith(javaClass<AssertionError>()) {
            expect("pass").toBe("fail")
        }.getMessage()?.should?.be("expected <pass> to be <fail>")

        "james".should.be("james")

        failsWith(javaClass<AssertionError>()) {
            "pass".should.be("fail")
        }
    }

    test fun toNotBe() {
        expect("james").toNotBe("fail")

        failsWith(javaClass<AssertionError>()) {
            expect("fail").toNotBe("fail")
        }

        "james".should.notBe("fail")

        failsWith(javaClass<AssertionError>()) {
            "fail".should.notBe("fail")
        }
    }

    test fun toBeNull() {
        expect(null).toBeNull()

        failsWith(javaClass<AssertionError>()) {
            expect("pass").toBeNull()
        }

        null.should.beNull()

        failsWith(javaClass<AssertionError>()) {
            "pass".should.beNull()
        }
    }

    test fun toNotBeNull() {
        expect("asdasd").toNotBeNull()

        failsWith(javaClass<AssertionError>()) {
            expect(null).toNotBeNull()
        }

        "asdasd".should.notBeNull()

        failsWith(javaClass<AssertionError>()) {
            null.should.notBeNull()
        }
    }
}