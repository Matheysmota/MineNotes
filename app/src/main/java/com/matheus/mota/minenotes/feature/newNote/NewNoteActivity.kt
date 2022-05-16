package com.matheus.mota.minenotes.feature.newNote

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
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
                saveNote()
                finish()
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }

    override fun setupListeners() {
        super.setupListeners()
        setupNote()
    }
    private fun saveNote(){
        viewModel.saveNotes()
    }
    private fun setupNote() {
        updateTextNote()
        /* set change color in cardView */
        newNoteBinding.editNoteLightBlueButton.setOnClickListener {
            newNoteBinding.editNoteCardRoot.setCardForegroundColor(getColorStateList(R.color.card_light_blue_color))
        }
        newNoteBinding.editNoteLightGreenButton.setOnClickListener {
            newNoteBinding.editNoteCardRoot.setCardForegroundColor(getColorStateList(R.color.card_light_green_color))
        }
        newNoteBinding.editNotePastelRedButton.setOnClickListener {
            newNoteBinding.editNoteCardRoot.setCardForegroundColor(getColorStateList(R.color.card_pastel_red_color))
        }
        newNoteBinding.editNotePastelYellowButton.setOnClickListener{
            newNoteBinding.editNoteCardRoot.setCardForegroundColor(getColorStateList(R.color.card_pastel_yellow_color))
        }
        newNoteBinding.editNotePurpleButton.setOnClickListener{
            newNoteBinding.editNoteCardRoot.setCardForegroundColor(getColorStateList(R.color.card_purpple_color))
        }
    }
    private fun updateTextNote(){
        newNoteBinding.editNoteTittleEditText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                newNoteBinding.editNoteCardTittle.setText(s)
            }
        })

        newNoteBinding.editNoteDescriptionEditText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                newNoteBinding.editNoteCardDescription.setText(s)
            }
        })


    }
}


