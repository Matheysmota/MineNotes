package com.matheus.mota.minenotes.feature.editNote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.common.extentions.base.BaseAppCompatActivity
import com.matheus.mota.minenotes.common.extentions.Color
import com.matheus.mota.minenotes.common.extentions.IntentValues
import com.matheus.mota.minenotes.common.extentions.setColor
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.databinding.ActivityEditNoteBinding
import com.matheus.mota.minenotes.viewModel.editNote.EditNoteViewModel
import com.matheus.mota.minenotes.viewModel.editNote.EditNoteViewModelFactory
import com.matheus.mota.minenotes.viewModel.editNote.repository.EditNoteRepository

class EditNoteActivity : BaseAppCompatActivity() {

    companion object {
        fun getIntent(context: Context, note: Note): Intent {
            val intent = Intent(context, EditNoteActivity::class.java)
            intent.putExtra(IntentValues.NOTE_DATA.get, note)
            return intent
        }
    }

    private val editNoteBinding by lazy { ActivityEditNoteBinding.inflate(layoutInflater) }
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            EditNoteViewModelFactory(EditNoteRepository())
        )[EditNoteViewModel::class.java]
    }
    lateinit var note: Note
    private var color = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(editNoteBinding.root)
    }

    override fun setupIntentExtras() {
        super.setupIntentExtras()
        note = intent.getParcelableExtra(IntentValues.NOTE_DATA.get)!!
    }
    override fun setupScreen() {
        super.setupScreen()
        setSupportActionBar(editNoteBinding.editNoteToolbar)
        setupNote(note)
        updateTextNote()
    }
    override fun setupListeners() {
        super.setupListeners()
        setNoteColor()
        editNoteBinding.editNoteDeleteButton.setOnClickListener {
            viewModel.deleteNote(this, note)
            finish()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_note_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.editNoteMenu_discard -> {
                finish()
            }
            R.id.editNoteMenu_save -> {
                viewModel.editNote(this, Note(note.id,
                    editNoteBinding.editNoteCardTittle.text.toString(),
                    editNoteBinding.editNoteCardDescription.text.toString(),
                    setNoteColor()
                ))
                finish()
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }
    private fun setupNote(note: Note) {
        editNoteBinding.apply {
            editNoteCardRoot.backgroundTintList = getColorStateList(note.noteColor)
            editNoteCardTittle.text = note.noteTittle
            editNoteCardDescription.text = note.noteDescription

            /* set ediText's */
            editNoteTittleEditText.setText(note.noteTittle)
            editNoteDescriptionEditText.setText(note.noteDescription)

        }
    }
    private fun setNoteColor(): Int {
        editNoteBinding.run {
            editNoteLightBlueButton.setOnClickListener {
                color = setColor(Color.BLUE)
                updateColor(color)
            }
            editNoteLightGreenButton.setOnClickListener {
                color = setColor(Color.GREEN)
                updateColor(color)
            }
            editNotePastelRedButton.setOnClickListener {
                color = setColor(Color.RED)
                updateColor(color)
            }
            editNotePastelYellowButton.setOnClickListener {
                color = setColor(Color.YELLOW)
                updateColor(color)
            }
            editNotePurpleButton.setOnClickListener {
                color = setColor(Color.PURPLE)
                updateColor(color)
            }
        }
        return color
    }
    private fun updateColor(color: Int){
        val colorStateList = getColorStateList(color)
        editNoteBinding.editNoteCardRoot.backgroundTintList = colorStateList
    }
    private fun updateTextNote() {
        editNoteBinding.editNoteTittleEditText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                editNoteBinding.editNoteCardTittle.setText(s)
            }
        })

        editNoteBinding.editNoteDescriptionEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                editNoteBinding.editNoteCardDescription.setText(s)
            }
        })

    }
}