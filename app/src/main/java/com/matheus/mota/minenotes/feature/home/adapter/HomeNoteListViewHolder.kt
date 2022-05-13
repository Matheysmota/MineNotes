package com.matheus.mota.minenotes.feature.home.adapter

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.minenotes.R

class HomeNoteListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val root by lazy { itemView.findViewById<CardView>(R.id.mineNote_root) }
    val noteTittle by lazy { itemView.findViewById<TextView>(R.id.mineNote_tittle) }
    val noteDescription by lazy { itemView.findViewById<TextView>(R.id.mineNote_description)}

}