package com.matheus.mota.minenotes.viewModel.newNote.repository

import android.content.Context

interface INewNoteRepository {
    suspend fun saveNote()
}