package com.matheus.mota.minenotes.feature.home

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.common.BaseAppCompatActivity
import com.matheus.mota.minenotes.common.extentions.invisible
import com.matheus.mota.minenotes.common.extentions.visible
import com.matheus.mota.minenotes.data.cache.dao.NoteDao
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.databinding.ActivityHomeNoteBinding
import com.matheus.mota.minenotes.feature.editNote.EditNoteActivity
import com.matheus.mota.minenotes.feature.home.adapter.HomeNoteListAdapter
import com.matheus.mota.minenotes.feature.home.adapter.HomeNoteListener
import com.matheus.mota.minenotes.feature.newNote.NewNoteActivity
import com.matheus.mota.minenotes.viewModel.homeNote.HomeNoteViewModel
import com.matheus.mota.minenotes.viewModel.homeNote.HomeNoteViewModelFactory
import com.matheus.mota.minenotes.viewModel.homeNote.repository.HomeNoteRepository

class HomeNoteActivity : BaseAppCompatActivity(), HomeNoteListener {

    private val mineNotesBinding by lazy { ActivityHomeNoteBinding.inflate(layoutInflater) }
    private val noteListAdapter by lazy { HomeNoteListAdapter(this) }
    private lateinit var viewModel: HomeNoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mineNotesBinding.root)
        viewModel = ViewModelProvider(this, HomeNoteViewModelFactory(HomeNoteRepository()))[HomeNoteViewModel::class.java]
        viewModel.loadNotes()
    }

    override fun setupScreen() {
        super.setupScreen()
        setSupportActionBar(mineNotesBinding.toolbar)
//        setObservers()
        recyclerValidation(null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.homeMenu_add -> {
                startActivity(NewNoteActivity.getIntent(this))
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }

    private fun recyclerValidation(list: MutableList<Note>?) {
        if (list == null) {
            mineNotesBinding.homeNoteNoNotesTextView.visible()
            mineNotesBinding.homeNoteNoteInstructionTextView.visible()
        } else {
            mineNotesBinding.homeNoteNoNotesTextView.invisible()
            mineNotesBinding.homeNoteNoteInstructionTextView.invisible()
            /* in this function i set my recycler view */
        }
    }

    private fun setObservers(){
        viewModel.noteList.observe(this){ notesList ->
            mineNotesBinding.homeNoteNotesList.adapter = noteListAdapter
            noteListAdapter.populateAdapter(notesList)
        }
    }

    override fun onItemClicked(note: Note) {
        startActivity(EditNoteActivity.getIntent(this))
    }

}
