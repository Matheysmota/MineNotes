package com.matheus.mota.minenotes.viewModel.home

import androidx.lifecycle.MutableLiveData
import com.matheus.mota.minenotes.data.entity.Note

interface IHomeNoteRepository {
    suspend fun getNoteList(): MutableLiveData<Note>
}