package com.matheus.mota.minenotes.viewModel.homeNote.repository

import android.content.Context
import com.matheus.mota.minenotes.data.cache.NoteDataBase
import com.matheus.mota.minenotes.data.entity.Note

class HomeNoteRepository() : IHomeNoteRepository {

    private fun initDataBase(context: Context): NoteDataBase {
        return NoteDataBase.getDataClient(context)
    }


    // in this fuction we get note informations
    override suspend fun getNoteList(context: Context): MutableList<Note> {
        val noteListDataBase = initDataBase(context)
        return noteListDataBase.noteDao().getAllNotes()
    }

}