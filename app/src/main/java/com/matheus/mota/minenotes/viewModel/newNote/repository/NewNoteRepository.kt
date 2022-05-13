package com.matheus.mota.minenotes.viewModel.newNote.repository

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.matheus.mota.minenotes.data.cache.NoteDataBase
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.viewModel.homeNote.repository.IHomeNoteRepository

class NewNoteRepository(): INewNoteRepository {

    val databaseBuilder = Room.databaseBuilder(
    this as Context,
    NoteDataBase::class.java,
    "mineNotes.db"
    ).build()
    private val noteDao = databaseBuilder.noteDao()

    // in this fuction we get note informations
    override suspend fun saveNote() {
        noteDao.saveMineNote()
    }
}