package com.belajar.submissionpemula.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val name: String,
    val shortDesc: String,
    val longDesc: String,
    val photo: Int
) : Parcelable