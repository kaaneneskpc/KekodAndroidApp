package com.kaaneneskpc.diexample.analytics.di

import com.kaaneneskpc.diexample.analytics.AnalyticsService
import com.kaaneneskpc.diexample.analytics.AnalyticsServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class) // içerisindeki dependencyleri sadece activity'de kullanıcam diye belirtiyoruz.
abstract class AnalyticsModule {
    @Binds
    abstract fun bindAnalyticsService(analyticsServiceImpl: AnalyticsServiceImpl): AnalyticsService
}

// Hilt şu şekilde çalışacak
// Bakacak sen bir mödül yazmışsın. İçine constructora inject edilemeyen dependencyler var.
// Bindla etiketlenmiş şeylere bakıyor.
// Servis veriyor içine impl veriyor. Bu servisin kendisini alabilmem için bunun nesnesine verirsem bunu bana vericektir.
// Bunun generateni yazıyor arka planda.

