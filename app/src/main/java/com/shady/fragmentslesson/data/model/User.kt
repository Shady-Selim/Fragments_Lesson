package com.shady.fragmentslesson.data.model

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val id: Int,
    val fName: String,
    val lName: String,
    val score: Int
) : Parcelable