package com.matheus.mota.minenotes.viewModel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mota.minenotes.data.entity.Note
import kotlinx.coroutines.launch

class HomeNoteViewModel(private val repository: IHomeNoteRepository): ViewModel() {

    private val _note: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>().also {
            loadNotes()
        }
    }

    //use this fuction to observe my Note in Activity
    fun getNotes(): LiveData<List<Note>> {
        return _note
    }

    // get my data in my repositories
    private fun loadNotes() = viewModelScope.launch {

    }
}
