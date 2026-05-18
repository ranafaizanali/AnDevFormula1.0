package com.example.andevformula.m10_viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _score = mutableStateOf(0)
    val score = _score

    fun increment() {
        _score.value++
    }

    fun decrement() {
        _score.value--
    }

}