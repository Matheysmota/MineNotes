package com.matheus.mota.minenotes.data.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.matheus.mota.minenotes.data.entity.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM Note")
    fun getAllNotes(): LiveData<MutableList<Note>>

    @Insert
    suspend fun saveNote(vararg note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(nota: Note)


}