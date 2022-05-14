package com.matheus.mota.minenotes.viewModel.homeNote.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.matheus.mota.minenotes.data.entity.Note

interface IHomeNoteRepository {
    suspend fun getNoteList(): LiveData<MutableList<Note>>
//    suspend fun saveNote(context: Context)
}