package com.matheus.mota.minenotes.viewModel.editNote.repository

import android.content.Context
import com.matheus.mota.minenotes.data.cache.NoteDataBase
import com.matheus.mota.minenotes.data.entity.Note

class EditNoteRepository(): IEditNoteRepository {

    private fun initDataBase(context: Context): NoteDataBase {
        return NoteDataBase.getDataBase(context)
    }

    override suspend fun deleteNote(context: Context, note: Note) {
        try {
            initDataBase(context).noteDao().deleteNote(note)
        } catch (e: Error){
            println("error: $e")
        }

    }
    override suspend fun editNote(context: Context, note: Note) {
        try {
            initDataBase(context).noteDao().updateNote(note)
        } catch (e: Error){
            println("error: $e")
        }
    }
}