package com.matheus.mota.minenotes.feature.newNote

import android.os.Bundle
import com.matheus.mota.minenotes.common.BaseAppCompatActivity
import com.matheus.mota.minenotes.databinding.ActivityNewNoteBinding

class NewNoteActivity : BaseAppCompatActivity() {

    private val newNoteBinding by lazy { ActivityNewNoteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(newNoteBinding.root)

    }
}