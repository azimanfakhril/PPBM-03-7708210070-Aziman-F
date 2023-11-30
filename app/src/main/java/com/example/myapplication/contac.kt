package com.example.myapplication

import android.provider.ContactsContract.CommonDataKinds.Email

data class Contact(
    val imageResource: Int,
    val nama: String,
    val no_telp: String,
    val email: String,
    val alamat: String,
)
