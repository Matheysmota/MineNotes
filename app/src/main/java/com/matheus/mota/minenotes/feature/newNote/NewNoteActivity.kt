package com.matheus.mota.minenotes.feature.newNote

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
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
    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, NewNoteActivity::class.java)
        }
    }

    private val newNoteBinding by lazy { ActivityNewNoteBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this, NewNoteViewModelFactory(NewNoteRepository()))[NewNoteViewModel::class.java] }
    private var myMenu : Menu? = null
    private var color: Int = setColor(Color.BLUE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(newNoteBinding.root)
    }

    override fun setupScreen() {
        super.setupScreen()
        setSupportActionBar(newNoteBinding.newNoteToolbar)
        checkFieldsAndToggleButton()
        initSelectedButton()
        updateColor(color)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        myMenu = menu
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
        setNoteColor()
        updateTextNote()
    }

    private fun checkFieldsAndToggleButton() {
        val tittleEmpty = newNoteBinding.newNoteCardTittle.text.length in 1..20
        val descriptionEmpty = newNoteBinding.newNoteCardDescription.text.length in 1..200

        val menuButton = myMenu?.findItem(R.id.newNoteMenu_save)
        menuButton.toggleEnabled(tittleEmpty && descriptionEmpty)
    }
    private fun saveNote() {
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
    private fun setNoteColor(): Int {
        newNoteBinding.run {
            newNoteLightBlueButton.setOnClickListener {
                color = setColor(Color.BLUE)
                updateColor(color)
                updateButtonSelected()
            }
            newNoteLightGreenButton.setOnClickListener {
                color = setColor(Color.GREEN)
                updateColor(color)
                updateButtonSelected()
            }
            newNotePastelRedButton.setOnClickListener {
                color = setColor(Color.RED)
                updateColor(color)
                updateButtonSelected()
            }
            newNotePastelYellowButton.setOnClickListener {
                color = setColor(Color.YELLOW)
                updateColor(color)
                updateButtonSelected()
            }
            newNotePurpleButton.setOnClickListener {
                color = setColor(Color.PURPLE)
                updateColor(color)
                updateButtonSelected()
            }
        }
        return color
    }
    private fun initSelectedButton(){
        @SuppressLint("UseCompatLoadingForDrawables")
        newNoteBinding.newNoteLightBlueButton.background = getDrawable(R.drawable.background_button_selected)
        newNoteBinding.newNoteLightBlueButton.backgroundTintMode = PorterDuff.Mode.MULTIPLY
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun updateButtonSelected() {
        val buttonList: Array<Button> = arrayOf(
            newNoteBinding.newNotePurpleButton,
            newNoteBinding.newNoteLightBlueButton,
            newNoteBinding.newNoteLightGreenButton,
            newNoteBinding.newNotePastelRedButton,
            newNoteBinding.newNotePastelYellowButton)
        for (button in buttonList) {
            if(button.backgroundTintList == getColorStateList(color)) {
                button.background = getDrawable(R.drawable.background_button_selected)
                button.backgroundTintMode = PorterDuff.Mode.MULTIPLY
            } else {
                button.background = getDrawable(R.drawable.background_button_not_selected)
                button.backgroundTintMode = PorterDuff.Mode.SCREEN
            }
        }
    }
    private fun updateTextNote() {
        newNoteBinding.run {
            newNoteTittleEditText.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                }
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                }
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    newNoteCardTittle.text = s
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
                    newNoteCardDescription.text = s
                }
            })
        }
    }
    private fun updateColor(color: Int) {
        newNoteBinding.newNoteCardRoot.backgroundTintList = getColorStateList(color)
    }

}