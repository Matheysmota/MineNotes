package com.matheus.mota.minenotes.feature.home.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.common.extentions.inflate
import com.matheus.mota.minenotes.data.entity.Note

class HomeNoteListAdapter(private val noteListListeners: HomeNoteListener):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val noteAdapterList: MutableList<Note> = mutableListOf()

    override fun getItemCount(): Int {
        return  noteAdapterList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = parent.inflate(R.layout.list_card_note)
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
        viewHolder.root.setOnClickListener {
            noteListListeners.onItemClicked(item)
        }

    }


}