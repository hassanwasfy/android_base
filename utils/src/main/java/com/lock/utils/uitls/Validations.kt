package com.dezz.uitls


import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isValidPhone(phone: String): Boolean {
    return android.util.Patterns.PHONE.matcher(phone).matches()
}

fun isValidPassword(password: String): Boolean {
    return password.length >= 8
}

fun isValidName(name: String): Boolean {
    return name.isNotBlank()
}

fun isValidBirthdate(birthdate: String): Boolean {
    return try {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
        dateFormat.parse(birthdate)
        true
    } catch (e: ParseException) {
        false
    }
}

fun isValidOtp(otp: String): Boolean {

    if (otp.length != 6) {
        return false
    }
    return otp.all { it.isDigit() }
}



/******** this method check if phone real not fake phone ***********/
fun isPhoneCorrect(phone: String,countryCode: String): Boolean {
    var phoneNumber: Phonenumber.PhoneNumber? = null
    val phoneNumberUtil: PhoneNumberUtil = PhoneNumberUtil.getInstance()
    var isValid = false
    var isMobile: PhoneNumberUtil.PhoneNumberType? = null
    try {
        phoneNumber = phoneNumberUtil.parse(phone, countryCode)
        isValid = phoneNumberUtil.isValidNumber(phoneNumber)
        isMobile = phoneNumberUtil.getNumberType(phoneNumber)
    } catch (e: NumberParseException) {
        e.printStackTrace()
        return false
    } catch (e: NullPointerException) {
        e.printStackTrace()
        return false
    }
    if (isValid
        && (PhoneNumberUtil.PhoneNumberType.MOBILE === isMobile || PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE === isMobile)
    )
        return true
    return false
}

/******************* this function to format phone pattern  , egyption phone will be 201-XXX-XXX-XXX
 * if user input 010XXXXXXXX , with country code egypt , result will be 201-0XX-XXX-XXX
 * if user input 201XXXXXXXX , with country code egypt , result will be 201-XXX-XXX-XXX
 * if user input 1XXXXXXXX , with country code egypt , result will be 201-XXX-XXX-XXX
 * ***************/
fun parseContact(contact: String?, countryNameCode: String): String {
    var phoneNumber: Phonenumber.PhoneNumber? = null
    val phoneNumberUtil: PhoneNumberUtil = PhoneNumberUtil.getInstance()
    var finalNumber: String = ""
    var isValid = false
    var isMobile: PhoneNumberUtil.PhoneNumberType? = null
    try {
        phoneNumber = phoneNumberUtil.parse(contact, countryNameCode)
        isValid = phoneNumberUtil.isValidNumber(phoneNumber)
        isMobile = phoneNumberUtil.getNumberType(phoneNumber)
    } catch (e: NumberParseException) {
        e.printStackTrace()
        return e.message.toString()
    } catch (e: NullPointerException) {
        e.printStackTrace()
        return e.message.toString()
    }
    if (isValid
        && (PhoneNumberUtil.PhoneNumberType.MOBILE === isMobile || PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE === isMobile)
    ) {
        finalNumber = phoneNumberUtil.format(
            phoneNumber,
            PhoneNumberUtil.PhoneNumberFormat.E164
        ).substring(1)
    }
    return finalNumber
}