package com.kaaneneskpc.diexample.analytics.network

import okhttp3.Interceptor
import okhttp3.Response

class OtherInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}