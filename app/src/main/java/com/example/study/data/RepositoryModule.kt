package com.example.study.data

import com.example.study.network.service.TravelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideRemoteRepository(
        travelService: TravelService
    ):RemoteRepository {
        return RemoteRepositoryImpl(travelService)
    }
}