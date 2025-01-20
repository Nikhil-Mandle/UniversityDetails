package com.nikhilproject.data.repository_impl

import com.nikhilproject.data.local.CourseDataSource.genreList
import com.nikhilproject.domain.model.University
import com.nikhilproject.domain.repository.UniversityDetailsRepository

class UniversityDetailsRepositoryImpl : UniversityDetailsRepository {
    override suspend fun getUniversityDetails(): List<University> {
        return genreList
    }
}