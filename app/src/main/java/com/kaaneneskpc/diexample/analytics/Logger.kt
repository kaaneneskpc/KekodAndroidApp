package com.kaaneneskpc.diexample.analytics

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Logger @Inject constructor(
    @ApplicationContext private val context: Context,
    @ActivityContext private val activityContext: Context
) {
    fun log(message: String) {
        println(message)
    }
}


// activityler applicationlar applicationContextler büyük objeler memoryde çokça yer kaplar.
// Bunların garbage collector tarafından temizlenmesi gerekir.
// Contexti parametre olarak verirsek silinimez hale getiriyoruz bu da memory leak'e sebep olur.
// Parametre olarak verdğimizde sen bunu tut diyorsun normalde başka activitye geçtiğinde bu activity silinir.
