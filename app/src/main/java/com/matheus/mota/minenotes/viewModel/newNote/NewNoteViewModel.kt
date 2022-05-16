package com.matheus.mota.minenotes.viewModel.newNote

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mota.minenotes.data.cache.NoteDataBase
import com.matheus.mota.minenotes.data.cache.dao.NoteDao
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.viewModel.newNote.repository.INewNoteRepository
import kotlinx.coroutines.launch

class NewNoteViewModel(private val repository: INewNoteRepository, private val noteDao: NoteDao): ViewModel() {

    private val _note: MutableLiveData<MutableList<Note>> by lazy {
        MutableLiveData<MutableList<Note>>().also {
            this.saveNotes()
        }
    }
    //use this fuction to observe my Note in Activity
    fun note(): LiveData<MutableList<Note>> {
        return _note
    }
    // get my data in my repositories
    private fun saveNotes() {
        viewModelScope.launch {
            noteDao.saveNote()
        }
    }

}
