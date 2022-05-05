package com.matheus.mota.minenotes.feature.editNote

import android.os.Bundle
import com.matheus.mota.minenotes.common.BaseAppCompatActivity
import com.matheus.mota.minenotes.databinding.ActivityEditNoteBinding

class EditNoteActivity : BaseAppCompatActivity() {

    private val editNoteBinding by lazy { ActivityEditNoteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(editNoteBinding.root)

    }
}