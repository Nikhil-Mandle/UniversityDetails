package com.nikhilproject.domain.repository

import com.nikhilproject.domain.model.University

interface UniversityDetailsRepository {

    suspend fun getUniversityDetails(): List<University>
}