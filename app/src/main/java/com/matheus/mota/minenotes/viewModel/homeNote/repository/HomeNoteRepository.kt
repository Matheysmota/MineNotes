package com.matheus.mota.minenotes.viewModel.homeNote.repository

import android.content.Context
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.data.cache.NoteDataBase
import com.matheus.mota.minenotes.data.entity.Note

class HomeNoteRepository() : IHomeNoteRepository {

    fun initDataBase(context: Context): NoteDataBase {
        return NoteDataBase.getDataBase(context)
    }


    // in this fuction we get note informations
    override suspend fun getNoteList(): MutableList<Note> {
        return mutableListOf(
            Note(1, "tittle 1", "desc1", R.color.card_pastel_red_color),
            Note(2, "tittle 2", "desc2", R.color.card_light_blue_color)
        )
    }
}