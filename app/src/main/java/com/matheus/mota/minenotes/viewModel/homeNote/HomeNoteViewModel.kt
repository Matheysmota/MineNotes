package com.matheus.mota.minenotes.viewModel.homeNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mota.minenotes.data.cache.dao.NoteDao
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.viewModel.homeNote.repository.IHomeNoteRepository
import kotlinx.coroutines.launch

class HomeNoteViewModel(private val repository: IHomeNoteRepository): ViewModel() {

    private var _noteList =  MutableLiveData<MutableList<Note>>()
    var noteList: LiveData<MutableList<Note>> = _noteList


    // get my Livedata to used in activity
    fun loadNotes(): MutableLiveData<MutableList<Note>> {
        viewModelScope.launch {
            _noteList.value = repository.getNoteList()
        }
        return _noteList
    }
}
