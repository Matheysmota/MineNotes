package com.matheus.mota.minenotes.viewModel.editNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.viewModel.editNote.repository.EditNoteRepository


class EditNoteViewModelFactory(private val repository: EditNoteRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(EditNoteViewModel::class.java)) {
            return EditNoteViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}