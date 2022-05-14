package com.matheus.mota.minenotes.viewModel.newNote.repository

import android.content.Context
import androidx.room.Room
import com.matheus.mota.minenotes.data.cache.NoteDataBase

class NewNoteRepository(): INewNoteRepository {

    val databaseBuilder = Room.databaseBuilder(
    this as Context,
    NoteDataBase::class.java,
    "mineNotes.db"
    ).build()
    private val noteDao = databaseBuilder.noteDao()

    // in this fuction we get note informations
    override suspend fun saveNote() {
        noteDao.saveNote()
    }
}