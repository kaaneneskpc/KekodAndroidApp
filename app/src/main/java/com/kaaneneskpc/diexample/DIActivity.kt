package com.kaaneneskpc.diexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kaaneneskpc.R
import com.kaaneneskpc.diexample.analytics.AnalyticsAdapter
import com.kaaneneskpc.diexample.analytics.di.AuthInterceptorRetrofit
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class DIActivity : AppCompatActivity() {

    @Inject
    lateinit var analyticsAdapter: AnalyticsAdapter

    @AuthInterceptorRetrofit
    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defaultCodes()
        analyticsAdapter.analyticsService.analyticsMethod()
    }

    private fun defaultCodes() {
        enableEdgeToEdge()
        setContentView(R.layout.activity_diactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}



/* Classların birbirine bağımlılığı en az olması lazım ki yapılan bir değişiklik mesela netmera yerine dataroid
kullanılmak istendiğinde tek tek gidip her classın içinden değişiklikleri yapmamak lazım.
Class'a nesneler kendi içerisinde oluşturuluyorsa  bunu tightly coupling olarak adlandırılır.
Tam tersine de loosely coupling olarak adlandırılır.

cohesion ise sınıfın ya da modulun ne kadar iyi tanımlandığını belirtir.

Yüksek cohesion bir sınıfın modülün ya da fonksiyonun tek bir sorumluluğu olması ve bu sorumluluğu en iyi şekilde
yerine getirmesi anlamına gelir.

tight coupling -> low cohesiona sebebiyet verir kodun okunabilirliği ve bakımı zorlaşır.
loosley coupling ve high cohesiona sebebiyet verir kodun okunabilirliği ve bakımı kolaylaşır.

Dependency Inversion -> High level modüller low level modüllere bağlı olmamalıdır. Her ikisi de abstractionlara bağlı olmalıdır.
Inversion Of Control -> High level modüller low level modüllerin nasıl çalıştığını kontrol etmemelidir. Bu işlemi başka bir modül yapmalıdır.
(Dataroid ve Netmera örneğinde olduğu gibi yapacağı işlemler kendi tarafından yönetilmemeli)

En kısa DI tanımı classin içindeki tüm bağımlılıkları constructorunu al olmuyorsa field olarak inject et.
Ne kadar az bağımlı olursa kopyaları oluşturulması ve test edilmesi daha kolay olur.



Çok çok özetle ->

Manual yaparsak bir tane container lazım tüm dependencyleri oraya tightly olarak coupled edilir. İstenilen şey bu
DI(Hilt ve koin) arka planda bunu yapıyor zaten. Sonra ilgili yerlere loosely coupled olarak inject edilir.

Koin bu service locator patterni kullanır.
Hilt bunu compile time(build sırasında generate edilen kodlar) da yapar. (Daha performanslıdır)(Injection Pattern)

Koin runtime -> runtimeda yaptığı performans sıkıntı ama build time kısaltıyor.
Hilt build time -> süreyi artırdığı için bi tık sıkıntı ama runtime da exception fırlatmıyor.(Bir kere derlendiğinde her şeyi okdir)





*/

