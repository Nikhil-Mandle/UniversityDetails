package com.nikhilproject.data.di

import com.nikhilproject.data.repository_impl.UniversityDetailsRepositoryImpl
import com.nikhilproject.domain.repository.UniversityDetailsRepository
import org.koin.dsl.module

val dataModule = module {
    single<UniversityDetailsRepository> { UniversityDetailsRepositoryImpl() }
}

