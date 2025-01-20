package com.nikhilproject.universitydetails

import android.app.Application
import com.nikhilproject.data.di.DataModule
import com.nikhilproject.data.di.DomainModule
import com.nikhilproject.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)

            modules(
                DataModule().module,
                DomainModule().module,
                presentationModule
            )
        }

    }

}