package com.shady.fragmentslesson.ui.main

import androidx.lifecycle.ViewModel
import com.shady.fragmentslesson.data.Repo

class MainViewModel : ViewModel() {
    private val repo = Repo()
    fun getAllUsers() = repo.getAllUsers()
}