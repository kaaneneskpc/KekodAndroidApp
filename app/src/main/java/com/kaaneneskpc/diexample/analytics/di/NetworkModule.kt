package com.kaaneneskpc.diexample.analytics.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object NetworkModule {

    @AuthInterceptorRetrofit
    @Provides // beklenen parametre ve dönüş tipini beklemeden senin vereceğin dönüş tipini kullanmak istersek ekliyoruz.
    fun provideAuthRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            // .addInterceptor(AuthInterceptor())
            .build()
    }

    @OtherInterceptorRetrofit
    @Provides
    @Singleton // -> doğası gereği memoryde tek bir obje olarak yer kaplayan ve garbage collector tarafından temizlenmeyen objeler için kullanılır.
    fun provideOtherRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            // .addInterceptor(OtherInterceptor())
            .build()
    }
}