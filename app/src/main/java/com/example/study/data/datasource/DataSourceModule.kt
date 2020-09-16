package com.example.study.data.datasource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object DataSourceModule {

    @Provides
    fun provideMemberSource(): MemberDataSource {
        return MemberDataSourceImpl()
    }

    @Provides
    fun provideTravelSource(): TravelDataSource {
        return TravelDataSourceImpl()
    }
}