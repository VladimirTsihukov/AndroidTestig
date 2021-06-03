package com.androidapp.testinghw

import org.junit.Test

import org.junit.Assert.*

class PasswordValidatorTest {

    @Test
    fun passwordValidator_NullPassword() {
        assertFalse(PasswordValidator.passwordIsValid(null))
    }

    @Test
    fun passwordValidator_EmptyPassword() {
        assertFalse(PasswordValidator.passwordIsValid(""))
    }

    @Test
    fun passwordValidator_moreThanSevenValue() {
        assertTrue(PasswordValidator.passwordIsValid("1234567"))
    }

    @Test
    fun passwordValidator_lessThanSevenValue() {
        assertFalse(PasswordValidator.passwordIsValid("123456"))
    }

}