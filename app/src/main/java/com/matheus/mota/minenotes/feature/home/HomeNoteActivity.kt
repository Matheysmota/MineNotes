package com.matheus.mota.minenotes.feature.home

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.common.extentions.base.BaseAppCompatActivity
import com.matheus.mota.minenotes.common.extentions.invisible
import com.matheus.mota.minenotes.common.extentions.visible
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

    private lateinit var color: ColorStateList
    private val mineNotesBinding by lazy { ActivityHomeNoteBinding.inflate(layoutInflater) }
    private val noteListAdapter by lazy { HomeNoteListAdapter(this) }
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            HomeNoteViewModelFactory(HomeNoteRepository())
        )[HomeNoteViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mineNotesBinding.root)
        viewModel.loadNotes(this)

    }
    override fun onStart() {
        super.onStart()
        viewModel.loadNotes(this)
    }

    override fun setupScreen() {
        super.setupScreen()
        setObservers()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_note_menu, menu)
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
    override fun onItemClicked(note: Note) {
        startActivity(EditNoteActivity.getIntent(this, note))
    }

    override fun getColor(): ColorStateList {
        viewModel.noteList.observe(this){
            it.forEach {
                color = getColorStateList(it.noteColor)
            }
        }
        return color
    }
    private fun setObservers() {
        viewModel.noteList.observe(this) { notesList ->
            recyclerValidation(notesList)
        }
    }
    private fun recyclerValidation(list: List<Note>?) {
        setToolbar(list)
        if (list == null) {
            mineNoteTittle().visible()
            mineNoteInstruction().visible()
        } else {
            mineNoteTittle().invisible()
            mineNoteInstruction().invisible()

            /* in this function i set my recycler view */
            mineNotesBinding.homeNoteNotesList.adapter = noteListAdapter
            noteListAdapter.populateAdapter(list as MutableList<Note>)
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setToolbar(list: List<Note>?) {
        if (list == null) {
            setSupportActionBar(mineNotesBinding.toolbar)
        } else {
            setSupportActionBar(mineNotesBinding.toolbar)
            mineNotesBinding.toolbar.background = getDrawable(R.color.appbar_color)
            window.statusBarColor = ContextCompat.getColor(this, R.color.appbar_color)
        }
    }

    private fun mineNoteInstruction() = mineNotesBinding.homeNoteNoteInstructionTextView
    private fun mineNoteTittle() = mineNotesBinding.homeNoteNoNotesTextView
}
