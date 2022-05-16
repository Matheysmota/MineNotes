package com.matheus.mota.minenotes.viewModel.newNote.repository

import android.content.Context
import androidx.room.Room
import com.matheus.mota.minenotes.data.cache.NoteDataBase

class NewNoteRepository(): INewNoteRepository {

    fun initDataBase(context: Context): NoteDataBase {
        return NoteDataBase.getDataBase(context)
    }

    // in this fuction we get note informations
    override suspend fun saveNote(context: Context) {
        initDataBase(context).noteDao().saveNote()
    }
}