
package com.example.study.network

import com.example.study.network.service.TravelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
object ServiceModule {

    @Provides
    fun provideTravelService(@Named("travelRetrofit") retrofit: Retrofit): TravelService {
        return retrofit.create(TravelService::class.java)
    }
}
