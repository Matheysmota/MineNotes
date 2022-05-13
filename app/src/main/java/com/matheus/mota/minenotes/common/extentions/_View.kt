package com.matheus.mota.minenotes.common.extentions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible


fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun View.visible() {
    this.isVisible = true
}
fun View.invisible() {
    this.isVisible = false
}