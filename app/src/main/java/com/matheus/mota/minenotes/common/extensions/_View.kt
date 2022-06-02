package com.matheus.mota.minenotes.common.extentions

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import com.matheus.mota.minenotes.common.utils.DISABLED_VIEW_ALPHA
import com.matheus.mota.minenotes.common.utils.ENABLED_VIEW_ALPHA


fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun MenuItem?.toggleEnabled(isEnabled: Boolean) {
    this?.isEnabled = isEnabled
    this?.isVisible = isEnabled
    }



fun View.visible() {
    this.isVisible = true
}
fun View.invisible() {
    this.isVisible = false
}

fun setToast(context: Context, string: String){
    Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
}