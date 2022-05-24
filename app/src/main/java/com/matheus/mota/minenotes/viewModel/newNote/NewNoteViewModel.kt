package com.matheus.mota.minenotes.viewModel.newNote

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.viewModel.newNote.repository.INewNoteRepository
import kotlinx.coroutines.launch

class NewNoteViewModel(private val repository: INewNoteRepository) : ViewModel() {

    // já pensando na mudança do aplicativo.
    private val _note: MutableLiveData<Note> by lazy { MutableLiveData <Note> () }
    val note: LiveData<Note>
        get() = _note



    // get my data in my repositories
    fun saveNotes(context: Context, myNote: Note): Boolean{
        var myResponse: Boolean = true
        val condition = myNote.noteTittle.length in 1..20 && myNote.noteDescription.length in 1..200

        viewModelScope.launch {
            myResponse = if(condition){
                repository.saveNote(context, myNote)
                true
            } else {
                val error = "Impossível salvar está nota"
                print(error)
                false
            }
        }
        return myResponse
    }

//    fun getNotes(context: Context): MutableList<Note>{
//
//        return
//    }

}
