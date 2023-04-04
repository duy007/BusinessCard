package com.learnandroid.businesscard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

data class ContactInfo(var info: String, var icon: ImageVector, var desc: String)

object Contacts {
    var phone = ContactInfo("(206) 673 1196", Icons.Outlined.Phone, "phone")
    var social = ContactInfo("@dnh7", Icons.Outlined.Share, "email")
    var email = ContactInfo("dnh7@uw.edu", Icons.Outlined.Email, "email")


    var contactList = listOf(phone, social, email)
}