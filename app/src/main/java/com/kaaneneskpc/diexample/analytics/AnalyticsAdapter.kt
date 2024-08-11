package com.kaaneneskpc.diexample.analytics

import javax.inject.Inject

class AnalyticsAdapter @Inject constructor(val analyticsService: AnalyticsService)



// İnterfaceler state tutamadıkları için hilte kullanacağımızı impl servisleri ile belirtiriz.
// Eğer bir interface'i depend etmek istiyorsak onu kullanan bir sınıf yazarız ve modül yardımıyla inject ediyor olacağız.
// Ya da değiştirilemez sınıflar için (retrofit for example) bunları da modül yardımıyla inject ediyor olacağız.