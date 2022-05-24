package com.matheus.mota.minenotes.feature.newNote

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.view.menu.MenuItemImpl
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.common.base.BaseAppCompatActivity
import com.matheus.mota.minenotes.common.extentions.Color
import com.matheus.mota.minenotes.common.extentions.setColor
import com.matheus.mota.minenotes.common.extentions.setToast
import com.matheus.mota.minenotes.common.extentions.toggleEnabled
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.databinding.ActivityNewNoteBinding
import com.matheus.mota.minenotes.viewModel.newNote.NewNoteViewModel
import com.matheus.mota.minenotes.viewModel.newNote.NewNoteViewModelFactory
import com.matheus.mota.minenotes.viewModel.newNote.repository.NewNoteRepository

class NewNoteActivity : BaseAppCompatActivity() {

    /* my intent */
    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, NewNoteActivity::class.java)
        }
    }

    private val newNoteBinding by lazy { ActivityNewNoteBinding.inflate(layoutInflater) }
    private val viewModel by lazy {  ViewModelProvider(this, NewNoteViewModelFactory(NewNoteRepository()))[NewNoteViewModel::class.java] }

    private var color: Int = setColor(Color.PURPLE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(newNoteBinding.root)
    }

    override fun setupScreen() {
        super.setupScreen()
        setSupportActionBar(newNoteBinding.newNoteToolbar)
        checkFieldsAndToggleButton()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_note_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
                R.id.newNoteMenu_save -> {
                    saveNote()
                }
            }
        return super.onOptionsItemSelected(menuItem)
    }
    override fun setupListeners() {
        super.setupListeners()
        setupNote()
    }

    private fun checkFieldsAndToggleButton() {
        val tittleEmpty = newNoteBinding.newNoteCardTittle.text.length in 1..20
        val descriptionEmpty = newNoteBinding.newNoteCardDescription.text.length in 1..200

        val menuButton = findViewById<View>(R.id.newNoteMenu_save)
        menuButton.toggleEnabled(tittleEmpty && descriptionEmpty)
    }
    private fun setNoteColor(): Int {
        newNoteBinding.run {
            newNoteLightBlueButton.setOnClickListener {
                color = setColor(Color.BLUE)
                updateColor(color)
            }
            newNoteLightGreenButton.setOnClickListener {
                color = setColor(Color.GREEN)
                updateColor(color)
            }
            newNotePastelRedButton.setOnClickListener {
                color = setColor(Color.RED)
                updateColor(color)
            }
            newNotePastelYellowButton.setOnClickListener {
                color = setColor(Color.YELLOW)
                updateColor(color)
            }
            newNotePurpleButton.setOnClickListener {
                color = setColor(Color.PURPLE)
                updateColor(color)
            }
        }
        return color
    }
    private fun saveNote(){
        val saveNotes = viewModel.saveNotes(
            this, Note(
                noteTittle = newNoteBinding.newNoteCardTittle.text.toString(),
                noteDescription = newNoteBinding.newNoteCardDescription.text.toString(),
                noteColor = setNoteColor()
            )
        )
        if(saveNotes){
            setToast(this@NewNoteActivity, "Note saved!")
            finish()
        } else {
            setToast(this@NewNoteActivity, "Unable to save note!")
        }
    }
    private fun setupNote() {
        updateTextNote()
        /* set change color in cardView */
        setNoteColor()
    }
    private fun updateColor(color: Int){
        val colorStateList = getColorStateList(color)
        newNoteBinding.newNoteCardRoot.backgroundTintList = colorStateList
    }
    private fun updateTextNote(){
        newNoteBinding.run {
            newNoteTittleEditText.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                }
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                }
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                        newNoteCardTittle.setText(s)
                }
            })
            newNoteDescriptionEditText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                }
                override fun beforeTextChanged(s: CharSequence, start: Int,
                                               count: Int, after: Int) {
                }
                override fun onTextChanged(s: CharSequence, start: Int,
                                           before: Int, count: Int) {
                    newNoteCardDescription.setText(s)
                }
            })
        }
    }
}


