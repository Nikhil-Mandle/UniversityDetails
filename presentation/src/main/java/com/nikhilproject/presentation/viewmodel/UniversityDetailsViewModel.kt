package com.nikhilproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikhilproject.domain.model.Course
import com.nikhilproject.domain.use_case.UniversityDetailsUseCase
import com.nikhilproject.presentation.utils.BottomSheetDetails
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

    private val originalUniversityList = mutableListOf<Course>()
    private val _filteredCourses = MutableStateFlow<List<Course>>(emptyList())

    private val _bottomSheetDetails = MutableStateFlow(
        BottomSheetDetails(0, emptyMap())
    )
    val bottomSheetDetails: StateFlow<BottomSheetDetails> = _bottomSheetDetails


    init {
        loadUniversityDetails()
    }

    private fun loadUniversityDetails() {
        viewModelScope.launch {
            try {
                _uiState.value = UIState.Loading
                val universityDetails = universityDetailsUseCase()
                originalUniversityList.addAll(universityDetails.flatMap { it.universities })
                _filteredCourses.value = originalUniversityList
                _uiState.value = UIState.Success(universityDetails)
            } catch (e: Exception) {
                _uiState.value = UIState.Error(e.localizedMessage ?: "An error occurred")
            }
        }
    }

    fun calculateCharacterOccurrencesFromList(courses: List<Course>) {
        // Combine all relevant fields into a single string
        val combinedText = courses.joinToString("") { "${it.name}${it.professor}" }

        // Calculate character occurrences
        val occurrences = combinedText.groupingBy { it }.eachCount()
        val sortedOccurrences = occurrences.entries
            .sortedByDescending { it.value }
            .take(3)
            .associate { it.toPair() }

        _bottomSheetDetails.value = BottomSheetDetails(combinedText.length, sortedOccurrences)
    }

}