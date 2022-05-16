package com.matheus.mota.minenotes.viewModel.homeNote.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.matheus.mota.minenotes.data.cache.dao.NoteDao
import com.matheus.mota.minenotes.data.entity.Note

interface IHomeNoteRepository {
    suspend fun getNoteList(): MutableList<Note>
//    suspend fun saveNote(context: Context)
}