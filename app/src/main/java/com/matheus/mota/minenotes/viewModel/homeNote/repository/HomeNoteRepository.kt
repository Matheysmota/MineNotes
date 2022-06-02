package com.matheus.mota.minenotes.viewModel.homeNote.repository

import android.content.Context
import com.matheus.mota.minenotes.data.cache.NoteDataBase
import com.matheus.mota.minenotes.data.entity.Note

class HomeNoteRepository() : IHomeNoteRepository {

    private fun initDataBase(context: Context): NoteDataBase {
        return NoteDataBase.getDataBase(context)
    }

    override suspend fun getNoteList(context: Context): List<Note> {
        return initDataBase(context).noteDao().getAllNotes()
    }
}