package com.nhinhnguyenuit.unittestjetpackcompose.di

import com.nhinhnguyenuit.unittestjetpackcompose.data.network.ApiService
import com.nhinhnguyenuit.unittestjetpackcompose.data.network.RetrofitInstance
import com.nhinhnguyenuit.unittestjetpackcompose.data.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService{
        return RetrofitInstance.api
    }

    @Provides
    @Singleton
    fun provideItemRepository(apiService: ApiService): ItemRepository{
        return ItemRepository(apiService)
    }

}