package com.example.dika.dikaapp.di

import com.example.dika.dikaapp.di.modules.AppHelperModule
import com.example.dika.dikaapp.fragmentviews.MainFragment
import dagger.Component

@Component(modules = [AppHelperModule::class])
interface AppComponent {
    fun inject(fragment: MainFragment)
}