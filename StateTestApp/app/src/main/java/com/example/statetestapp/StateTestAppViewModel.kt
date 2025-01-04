package com.example.statetestapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StateTestAppViewModel: ViewModel() {

    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private val _surName = MutableStateFlow("")
    val surName = _surName.asStateFlow()

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onSurNameChange(newSurName: String) {
        _surName.value = newSurName
    }
}