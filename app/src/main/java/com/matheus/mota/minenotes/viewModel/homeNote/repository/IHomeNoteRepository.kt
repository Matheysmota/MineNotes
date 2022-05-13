package com.matheus.mota.minenotes.viewModel.homeNote.repository

import android.content.Context
import com.matheus.mota.minenotes.data.entity.Note

interface IHomeNoteRepository {
    suspend fun getNoteList(context: Context): MutableList<Note>
//    suspend fun saveNote(context: Context)
}