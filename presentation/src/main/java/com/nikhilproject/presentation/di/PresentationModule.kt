package com.nikhilproject.presentation.di

import com.nikhilproject.presentation.viewmodel.UniversityDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        UniversityDetailsViewModel(get())
    }
}