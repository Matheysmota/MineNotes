package com.matheus.mota.minenotes.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.matheus.mota.minenotes.data.entity.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM Note")
    fun getAllNotes(): MutableList<Note>

    @Insert
    fun saveMineNote(vararg note: Note)

}