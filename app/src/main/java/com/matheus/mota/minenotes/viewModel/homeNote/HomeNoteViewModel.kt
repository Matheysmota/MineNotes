package com.matheus.mota.minenotes.viewModel.homeNote

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.viewModel.homeNote.repository.IHomeNoteRepository
import kotlinx.coroutines.launch

class HomeNoteViewModel(private val repository: IHomeNoteRepository): ViewModel() {

    private val _noteList: MutableLiveData<MutableList<Note>> = loadNotes() as MutableLiveData<MutableList<Note>>
    val notelist: LiveData<MutableList<Note>>
        get() = _noteList

    // get my Livedata to used in activity
    fun loadNotes(): LiveData<MutableList<Note>>? {
        var teste: LiveData<MutableList<Note>>? = null
        viewModelScope.launch {
            teste = repository.getNoteList()
        }
        return teste
    }


}
