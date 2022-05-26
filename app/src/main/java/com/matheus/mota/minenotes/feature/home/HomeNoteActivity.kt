package com.matheus.mota.minenotes.feature.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.common.base.BaseAppCompatActivity
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
    private val mineNotesBinding by lazy { ActivityHomeNoteBinding.inflate(layoutInflater) }
    private val noteListAdapter by lazy { HomeNoteListAdapter(this, this) }
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            HomeNoteViewModelFactory(HomeNoteRepository())
        )[HomeNoteViewModel::class.java]
    }
    private var myList = listOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mineNotesBinding.root)
        viewModel.loadNotes(this)
    }
    override fun onStart() {
        super.onStart()
        viewModel.loadNotes(this)
        setInterface(myList)
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

    private fun setObservers(): List<Note> {
        viewModel.noteList.observe(this) { notesList ->
            setInterface(notesList)
            myList = notesList
        }
        return myList
    }
    private fun setInterface(list: List<Note>) {
        if (list.isEmpty()) {
            mineNoteInstruction().visible()
            setToolbar(this, R.color.background_color)
        } else {
            /* in this function i set my recycler view */
            mineNotesBinding.homeNoteNotesList.adapter = noteListAdapter
            noteListAdapter.populateAdapter(list as MutableList<Note>)
            /* set view state */
            mineNoteInstruction().invisible()
            setToolbar(this, R.color.appbar_color)
        }
    }
    private fun setToolbar(context: Context, int: Int){
        mineNotesBinding.apply {
            @SuppressLint("UseCompatLoadingForDrawables")
            toolbar.background = getDrawable(int)
            window.statusBarColor = ContextCompat.getColor(context, int)
            setSupportActionBar(mineNotesBinding.toolbar)
        }
    }
    private fun mineNoteInstruction() = mineNotesBinding.homeNoteNoNotesContainer
}
