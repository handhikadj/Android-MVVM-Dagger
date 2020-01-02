package com.example.dika.dikaapp.di

import androidx.fragment.app.Fragment
import com.example.dika.dikaapp.di.modules.AppHelperModule
import dagger.Component

@Component(modules = [AppHelperModule::class])
interface AppComponent {
    fun inject(fragment: Fragment)
}