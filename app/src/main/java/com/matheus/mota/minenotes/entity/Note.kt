package com.matheus.mota.minenotes.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val noteTittle: String,
    val noteDescription: String,
    val noteColor: Int
): Parcelable