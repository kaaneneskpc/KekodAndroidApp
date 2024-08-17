package com.kaaneneskpc.diexample.analytics.di

import javax.inject.Qualifier

//Network Modulundeki return nesnenin birden fazla üretim yolu olmasını istiyorsak kullanırız.
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherInterceptorRetrofit




// RUNTİME default olanı hem Binary outputta olacak hem de reflection'da açık olacak
// SOURCE -> Binary üretilen kısımda bu olmicak
// BINARY -> Binary outputta olacak ama reflection'da kapalı olacak