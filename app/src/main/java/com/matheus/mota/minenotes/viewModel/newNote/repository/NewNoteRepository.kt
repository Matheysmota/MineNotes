package com.matheus.mota.minenotes.viewModel.newNote.repository

import android.content.Context
import com.matheus.mota.minenotes.data.cache.NoteDataBase
import com.matheus.mota.minenotes.data.entity.Note
import java.lang.Error

class NewNoteRepository(): INewNoteRepository {

    private fun initDataBase(context: Context): NoteDataBase {
        return NoteDataBase.getDataBase(context)
    }
    // in this fuction we get note informations
    override suspend fun saveNote(context: Context, note: Note) {
        try {
            initDataBase(context).noteDao().addNote(note)
        } catch (e: Error){
            print(e)
        }

    }

}