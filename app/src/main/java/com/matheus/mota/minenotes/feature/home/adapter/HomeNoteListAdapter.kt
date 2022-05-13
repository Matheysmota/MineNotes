package com.matheus.mota.minenotes.feature.home.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.common.extentions.inflate
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.feature.home.HomeNoteActivity

class HomeNoteListAdapter(private val noteListListeners: HomeNoteActivity):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var noteAdapterList: MutableList<Note> = mutableListOf()

    override fun getItemCount(): Int {
        return  noteAdapterList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = parent.inflate(R.layout.mine_note_card_list)
        return HomeNoteListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as HomeNoteListViewHolder
        val entity = noteAdapterList[position]

        bindItemViewHolder(itemViewHolder, entity, position)
    }
    @SuppressLint("SetTextI18n")
    private fun bindItemViewHolder(
        viewHolder: HomeNoteListViewHolder,
        item: Note,
        position: Int
    ) {
        viewHolder.noteTittle.text = "#${item.noteTittle}"
        viewHolder.noteDescription.text = "(${item.noteDescription})"
        viewHolder.root.setCardBackgroundColor(item.noteColor)

        //listeners
        viewHolder.root[position].setOnClickListener {
            noteListListeners.onItemClicked(item)
        }
    }

    fun populateAdapter(itemsList: MutableList<Note>) {
        noteAdapterList.clear()
        noteAdapterList = itemsList
        notifyItemRangeInserted(0, itemsList.size)
    }

}