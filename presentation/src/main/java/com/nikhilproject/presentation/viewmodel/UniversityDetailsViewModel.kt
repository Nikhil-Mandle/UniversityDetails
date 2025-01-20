package com.nikhilproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikhilproject.domain.model.Course
import com.nikhilproject.domain.model.University
import com.nikhilproject.domain.use_case.UniversityDetailsUseCase
import com.nikhilproject.presentation.utils.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UniversityDetailsViewModel(private val universityDetailsUseCase: UniversityDetailsUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState: StateFlow<UIState> = _uiState

    private val _selectedCourses = MutableStateFlow<List<Course>>(emptyList())
    val selectedCourses: StateFlow<List<Course>> = _selectedCourses

    private val universityList = mutableListOf<University>()

    init {
        loadUniversityDetails()
    }

    private fun loadUniversityDetails() {
        viewModelScope.launch {
            try {
                _uiState.value = UIState.Loading
                val universities = universityDetailsUseCase()
                universityList.addAll(universities)
                _uiState.value = UIState.Success(universities)
                updateSelectedCourses(0)
            } catch (e: Exception) {
                _uiState.value = UIState.Error(e.localizedMessage ?: "An error occurred")
            }
        }
    }

    fun setSelectedUniversity(index: Int) {
        updateSelectedCourses(index)
    }

    private fun updateSelectedCourses(index: Int) {
        _selectedCourses.value = universityList.getOrNull(index)?.universitiesCourses.orEmpty()
    }

    fun filterCourses(query: String) {
        viewModelScope.launch {
            val filteredCourses = if (query.isBlank()) {
                universityList.flatMap { it.universitiesCourses }
            } else {
                universityList.flatMap { it.universitiesCourses }
                    .filter { course ->
                        course.name.contains(query, ignoreCase = true) ||
                                course.professor.contains(query, ignoreCase = true)
                    }
            }
            _selectedCourses.value = filteredCourses
        }
    }
}
