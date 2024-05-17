package com.example.phoneviewer.fragments.main.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Model(
    val id: Long,
    val title: String,
    val photos: String
): Parcelable