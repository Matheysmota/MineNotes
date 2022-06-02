package com.matheus.mota.minenotes.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.matheus.mota.minenotes.data.cache.dao.NoteDao
import com.matheus.mota.minenotes.data.entity.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase() : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDataBase? = null

        fun getDataBase(context: Context): NoteDataBase {
            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {
                INSTANCE = Room
                    .databaseBuilder(context.applicationContext,
                        NoteDataBase::class.java,
                        "LOGIN_DATABASE")
                    .allowMainThreadQueries()
                    .build()
                return INSTANCE!!
            }
        }
    }
}
