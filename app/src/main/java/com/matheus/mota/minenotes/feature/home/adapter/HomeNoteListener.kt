package com.matheus.mota.minenotes.feature.home.adapter

import com.matheus.mota.minenotes.data.entity.Note

interface HomeNoteListener {
    fun onItemClicked(note: Note)
}