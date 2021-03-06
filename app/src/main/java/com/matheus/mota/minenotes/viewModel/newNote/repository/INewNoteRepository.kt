package com.matheus.mota.minenotes.viewModel.newNote.repository

import android.content.Context
import com.matheus.mota.minenotes.data.entity.Note

interface INewNoteRepository {
    suspend fun saveNote(context: Context, note: Note)

}