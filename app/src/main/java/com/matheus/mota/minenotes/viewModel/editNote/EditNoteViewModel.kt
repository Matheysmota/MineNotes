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

   fun editNote(context: Context, myNote: Note): Boolean{
       var myResponse: Boolean = true
       val condition = myNote.noteTittle.length in 1..20 && myNote.noteDescription.length in 1..200
       viewModelScope.launch {
           myResponse = if(condition){
               repository.editNote(context, myNote)
               true
           } else {
               val error = "Impossível salvar está nota"
               print(error)
               false
           }
       }
       return myResponse
    }

    fun deleteNote(context: Context, note: Note){
        viewModelScope.launch {
            repository.deleteNote(context, note)
        }
    }
}