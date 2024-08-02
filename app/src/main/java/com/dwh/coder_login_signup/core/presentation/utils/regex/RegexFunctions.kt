package com.dwh.coder_login_signup.core.presentation.utils.regex

object RegexFunctions {
    fun String.isEmail() : Boolean {
        return this.matches(Regex("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}+(\\s?)"))
    }

    fun numericRegex() = Regex("[^0-9]")

    fun String.containsLetter() : Boolean {
        return this.matches(Regex("^(?=.*[a-z])(?=.*[A-Z]).+$"))
    }

    fun String.containsNumber() : Boolean {
        return this.matches(Regex("^(?=.*[0-9]).+\$"))
    }

    fun String.containsSpecialCharacter() : Boolean {
        return this.matches(Regex("^(?=.*[@#&*-+=%_:;/,.¿¡?!]).+\$"))
    }
}