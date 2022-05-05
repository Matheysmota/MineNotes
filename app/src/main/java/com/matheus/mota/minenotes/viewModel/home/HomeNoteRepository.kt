package com.matheus.mota.minenotes.viewModel.home

import androidx.lifecycle.MutableLiveData
import com.matheus.mota.minenotes.data.entity.Note

class HomeNoteRepository(): IHomeNoteRepository {

    // in this fuction we get note informations
    override suspend fun getNoteList(): MutableLiveData<Note> {
        TODO("Not yet implemented")
    }

}