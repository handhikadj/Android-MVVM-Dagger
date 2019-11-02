package com.example.dika.dikaapp.di.modules

import com.example.dika.dikaapp.util.UIHelpers
import dagger.Module
import dagger.Provides

@Module
class AppHelperModule {

    @Provides
    fun provideUiHelper(): UIHelpers =
        UIHelpers()
}