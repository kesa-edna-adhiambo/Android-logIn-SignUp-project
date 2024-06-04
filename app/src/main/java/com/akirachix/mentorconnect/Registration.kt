package com.akirachix.mentorconnect

import android.provider.ContactsContract.CommonDataKinds.Email

data class Registration(
    var firstName: String,
    var lastName: String,
    var codeHiveId: String,
    var email: String,
    var userName: String,
    var password: String,
    var confirmPassword: String

)
