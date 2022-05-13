package com.matheus.mota.minenotes.viewModel.homeNote

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.viewModel.homeNote.repository.IHomeNoteRepository
import kotlinx.coroutines.launch

class HomeNoteViewModel(private val repository: IHomeNoteRepository): ViewModel() {

    private val _noteList = MutableLiveData<MutableList<Note>>()

    // get my Livedata to used in activity
    fun loadNotes(context: Context): LiveData<MutableList<Note>>  {
        viewModelScope.launch {
            _noteList.value = repository.getNoteList(context)
        }
        return _noteList
    }


}
