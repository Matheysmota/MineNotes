package com.matheus.mota.minenotes.common.base

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
        setupListeners()
        setupScreen()
    }

    protected open fun setupIntentExtras() {}
    protected open fun setupScreen() {}
    protected open fun setupListeners() {}

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}