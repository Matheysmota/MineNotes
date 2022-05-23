package com.matheus.mota.minenotes.viewModel.editNote.repository

import android.content.Context
import com.matheus.mota.minenotes.data.entity.Note

interface IEditNoteRepository {

    suspend fun deleteNote(context: Context, note: Note)
    suspend fun editNote(context: Context, note: Note)
}