package com.nikhilproject.data.di

import com.nikhilproject.domain.repository.UniversityDetailsRepository
import com.nikhilproject.domain.use_case.UniversityDetailsUseCase
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class DomainModule {

    @Factory
    fun provideEmployeeUseCase(repository: UniversityDetailsRepository): UniversityDetailsUseCase {
        return UniversityDetailsUseCase(repository)
    }
}