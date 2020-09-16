package com.example.study.network

import com.example.study.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    companion object {
        private const val TIME_OUT:Long = 15
        private val TRAVEL_URL =
            if(BuildConfig.DEBUG) "http://api.visitkorea.or.kr/openapi/service" else "http://api.visitkorea.or.kr/openapi/service"
    }

    @Provides
    @Named("travelRetrofit")
    fun provideTravelRetrofit(
        @Named("okHttpClient") okHttpClient: OkHttpClient
    ):Retrofit {
        return Retrofit.Builder()
            .baseUrl(TRAVEL_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Named("okHttpClient")
    fun provideOkHttp3(
        logger:HttpLoggingInterceptor
    ):OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(logger)
            .build()
    }

    @Provides
    fun provideHttpLoggingInterceptor():HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if(BuildConfig.DEBUG)
                level = HttpLoggingInterceptor.Level.BODY
        }
    }
}