package com.nikhilproject.data.di

import com.nikhilproject.domain.use_case.UniversityDetailsUseCase
import org.koin.dsl.module

val domainModule = module {
    single { UniversityDetailsUseCase(get()) }

}