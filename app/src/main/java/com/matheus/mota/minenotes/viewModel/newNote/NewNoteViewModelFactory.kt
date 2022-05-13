package com.matheus.mota.minenotes.viewModel.newNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.viewModel.newNote.repository.NewNoteRepository

class NewNoteViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewNoteViewModel::class.java)) {
            val repository = NewNoteRepository()
            NewNoteViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}