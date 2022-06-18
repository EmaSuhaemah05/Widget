package com.example.widget

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelLogin(
    var UserName : String,
    var Password: String
) : Parcelable
