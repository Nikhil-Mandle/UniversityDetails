package com.nikhilproject.domain.use_case

import com.nikhilproject.domain.model.University
import com.nikhilproject.domain.repository.UniversityDetailsRepository

class UniversityDetailsUseCase (private val repository: UniversityDetailsRepository) {

    suspend operator fun invoke(): List<University> = repository.getUniversityDetails()
}