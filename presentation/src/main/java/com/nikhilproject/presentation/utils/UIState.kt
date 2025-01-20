package com.nikhilproject.presentation.utils

import com.nikhilproject.domain.model.University

sealed class UIState {

    object Loading : UIState()
    data class Success(val data: List<University>) : UIState()
    data class Error(val message: String) : UIState()
}