package com.matheus.mota.minenotes.feature.home

import android.os.Bundle
import com.matheus.mota.minenotes.common.BaseAppCompatActivity
import com.matheus.mota.minenotes.databinding.ActivityHomeNoteBinding

class HomeNoteActivity : BaseAppCompatActivity() {

    private val mineNotesBinding by lazy { ActivityHomeNoteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mineNotesBinding.root)


    }

}