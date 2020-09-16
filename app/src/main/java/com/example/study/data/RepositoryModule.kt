package com.example.study.data

import com.example.study.data.datasource.MemberDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideRemoteRepository(
        memberDataSource: MemberDataSource
    ):RemoteRepository {
        return RemoteRepositoryImpl(memberDataSource)
    }
}