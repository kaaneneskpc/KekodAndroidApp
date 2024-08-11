package com.kaaneneskpc.diexample.analytics

import android.util.Log
import javax.inject.Inject

class AnalyticsServiceImpl @Inject constructor(): AnalyticsService {
    override fun analyticsMethod() {
        Log.i("AnalyticsServiceImpl", "method called")
    }
}
