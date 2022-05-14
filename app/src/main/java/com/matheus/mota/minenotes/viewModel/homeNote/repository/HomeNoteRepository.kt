package com.matheus.mota.minenotes.viewModel.homeNote.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.matheus.mota.minenotes.data.cache.NoteDataBase
import com.matheus.mota.minenotes.data.cache.dao.NoteDao
import com.matheus.mota.minenotes.data.entity.Note

class HomeNoteRepository() : IHomeNoteRepository {

    fun initDataBase(context: Context): NoteDataBase {
        return NoteDataBase.getDataBase(context)
    }


    // in this fuction we get note informations
    override suspend fun getNoteList(): LiveData<MutableList<Note>> {
        val noteDao: NoteDao
        return noteDao.getAllNotes()
    }

}