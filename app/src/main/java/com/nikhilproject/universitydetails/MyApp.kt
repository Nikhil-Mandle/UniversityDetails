package com.nikhilproject.universitydetails

import android.app.Application
import com.nikhilproject.data.di.dataModule
import com.nikhilproject.data.di.domainModule
import com.nikhilproject.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)

            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }

    }

}