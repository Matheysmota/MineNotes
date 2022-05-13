package com.matheus.mota.minenotes.feature.newNote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.common.BaseAppCompatActivity
import com.matheus.mota.minenotes.databinding.ActivityNewNoteBinding
import com.matheus.mota.minenotes.viewModel.homeNote.HomeNoteViewModel
import com.matheus.mota.minenotes.viewModel.homeNote.HomeNoteViewModelFactory
import com.matheus.mota.minenotes.viewModel.newNote.NewNoteViewModel
import com.matheus.mota.minenotes.viewModel.newNote.NewNoteViewModelFactory

class NewNoteActivity : BaseAppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, NewNoteActivity::class.java)
        }
    }

    private lateinit var viewModel: NewNoteViewModel
    private val newNoteBinding by lazy { ActivityNewNoteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(newNoteBinding.root)
        viewModel = ViewModelProvider(this, NewNoteViewModelFactory())[NewNoteViewModel::class.java]

    }

    override fun setupScreen() {
        super.setupScreen()
        setSupportActionBar(newNoteBinding.newNoteToolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_note_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.newNoteMenu_save -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }
}
