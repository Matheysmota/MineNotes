package com.matheus.mota.minenotes.feature.home

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
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.databinding.ActivityHomeNoteBinding
import com.matheus.mota.minenotes.feature.editNote.EditNoteActivity
import com.matheus.mota.minenotes.feature.home.adapter.HomeNoteListAdapter
import com.matheus.mota.minenotes.feature.home.adapter.HomeNoteListener
import com.matheus.mota.minenotes.feature.newNote.NewNoteActivity
import com.matheus.mota.minenotes.viewModel.homeNote.HomeNoteViewModel
import com.matheus.mota.minenotes.viewModel.homeNote.HomeNoteViewModelFactory

class HomeNoteActivity : BaseAppCompatActivity(), HomeNoteListener {

    private val mineNotesBinding by lazy { ActivityHomeNoteBinding.inflate(layoutInflater) }
    private val noteListAdapter by lazy { HomeNoteListAdapter(this) }
    private lateinit var viewModel: HomeNoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mineNotesBinding.root)
        viewModel = ViewModelProvider(this, HomeNoteViewModelFactory())[HomeNoteViewModel::class.java]

    }

    override fun setupScreen() {
        super.setupScreen()
        setSupportActionBar(mineNotesBinding.toolbar)
        setObservers()
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
            setObservers()
        }
    }

    private fun setObservers(){

        viewModel.loadNotes(this).observe(this){ notesList ->
            val teste = mutableListOf<Note>(Note(noteTittle = "Tittle 1", noteDescription = "Description 1", noteColor = R.color.card_pastel_red_color, id = 0), Note(noteTittle = "Tittle 2", noteDescription = "Description 2", noteColor = R.color.card_light_blue_color, id = 0))
            mineNotesBinding.homeNoteNotesList.adapter = noteListAdapter
            noteListAdapter.populateAdapter(teste)
        }
    }

    override fun onItemClicked(note: Note) {
        startActivity(EditNoteActivity.getIntent(this))
    }

}
