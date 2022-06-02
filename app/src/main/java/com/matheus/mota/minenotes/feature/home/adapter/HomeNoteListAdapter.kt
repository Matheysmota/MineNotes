package com.matheus.mota.minenotes.feature.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.minenotes.R
import com.matheus.mota.minenotes.common.extentions.inflate
import com.matheus.mota.minenotes.data.entity.Note
import com.matheus.mota.minenotes.feature.home.HomeNoteActivity

class HomeNoteListAdapter(private val noteListListeners: HomeNoteActivity, private val context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var noteAdapterList: MutableList<Note> = mutableListOf()

    override fun getItemCount(): Int {
        return  noteAdapterList.count()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = parent.inflate(R.layout.mine_note_card_list)
        return HomeNoteListViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as HomeNoteListViewHolder
        val entity = noteAdapterList[position]

        bindItemViewHolder(itemViewHolder, entity)
    }
    @SuppressLint("SetTextI18n")
    private fun bindItemViewHolder(viewHolder: HomeNoteListViewHolder, item: Note) {

        viewHolder.noteTittle.text = item.noteTittle
        viewHolder.noteDescription.text = item.noteDescription
        viewHolder.root.backgroundTintList = context.getColorStateList(item.noteColor)

        //listeners
        viewHolder.root.setOnClickListener {
            noteListListeners.onItemClicked(item)
        }
    }

    fun populateAdapter(itemsList: MutableList<Note>) {
        noteAdapterList.clear()
        noteAdapterList = itemsList
        notifyItemRangeInserted(0, itemsList.size)
    }
}
