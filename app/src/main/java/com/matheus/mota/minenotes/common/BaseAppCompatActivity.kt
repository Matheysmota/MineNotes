package com.matheus.mota.minenotes.common

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class BaseAppCompatActivity :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    protected open fun initView() {
        setupIntentExtras()
        setupScreen()
        setupListeners()
    }

    protected open fun setupIntentExtras() {}
    protected open fun setupScreen() {}
    protected open fun setupListeners() {}

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        return super.onOptionsItemSelected(menuItem)
    }

}