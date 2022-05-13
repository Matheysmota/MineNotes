package com.matheus.mota.minenotes.feature.editNote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.matheus.mota.minenotes.common.BaseAppCompatActivity
import com.matheus.mota.minenotes.databinding.ActivityEditNoteBinding

class EditNoteActivity : BaseAppCompatActivity() {

    private val editNoteBinding by lazy { ActivityEditNoteBinding.inflate(layoutInflater) }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, EditNoteActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(editNoteBinding.root)

    }
}