package com.matheus.mota.minenotes.viewModel.homeNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.viewModel.homeNote.repository.HomeNoteRepository

class HomeNoteViewModelFactory(private val repository: HomeNoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeNoteViewModel::class.java)) {
            return HomeNoteViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}