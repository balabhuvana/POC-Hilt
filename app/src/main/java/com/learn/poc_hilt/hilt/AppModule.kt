package com.learn.poc_hilt.hilt

import com.learn.poc_hilt.network.ApiWebService
import com.learn.poc_hilt.repo.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun providesRepository(apiService: ApiWebService) = MainRepository(apiService)
}