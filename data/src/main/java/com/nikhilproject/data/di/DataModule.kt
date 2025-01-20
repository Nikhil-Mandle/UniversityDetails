package com.nikhilproject.data.di

import com.nikhilproject.data.repository_impl.UniversityDetailsRepositoryImpl
import com.nikhilproject.domain.repository.UniversityDetailsRepository
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class DataModule {

    @Factory
    fun provideEmployeeRepository(): UniversityDetailsRepository {
        return UniversityDetailsRepositoryImpl()
    }
}