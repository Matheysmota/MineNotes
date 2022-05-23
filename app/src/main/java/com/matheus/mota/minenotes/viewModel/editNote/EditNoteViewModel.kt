package com.matheus.mota.minenotes.viewModel.editNote

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.viewModel.editNote.repository.IEditNoteRepository
import kotlinx.coroutines.launch

class EditNoteViewModel(private val repository: IEditNoteRepository): ViewModel() {

    private val _note: MutableLiveData<Note> by lazy { MutableLiveData <Note> () }
    val note: LiveData<Note>
        get() = _note

   fun editNote(context: Context, note: Note){
       if(note.noteTittle.length in 1..20 && note.noteDescription.length in 1..200) {
           viewModelScope.launch {
               repository.editNote(context, note)
           }
       } else {
           val error = "impossível editar nota"
           print(error)
       }
    }

    fun deleteNote(context: Context, note: Note){
        viewModelScope.launch {
            repository.deleteNote(context, note)
        }
    }
}