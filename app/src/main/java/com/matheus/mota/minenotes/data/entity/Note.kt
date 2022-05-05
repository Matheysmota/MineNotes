package com.matheus.mota.minenotes.data.entity

import android.content.res.ColorStateList
import android.graphics.Color

data class Note(
    val noteTittle: String,
    val noteDescription: String,
    var noteColor: Int
)