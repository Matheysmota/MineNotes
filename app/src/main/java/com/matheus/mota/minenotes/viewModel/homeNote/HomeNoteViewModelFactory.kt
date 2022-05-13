package com.matheus.mota.minenotes.viewModel.homeNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.viewModel.homeNote.repository.HomeNoteRepository
import kotlin.coroutines.coroutineContext

class HomeNoteViewModelFactory(repository: HomeNoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeNoteViewModel::class.java)) {
            val repository = HomeNoteRepository()
            HomeNoteViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}