package com.kaaneneskpc.kekodandroidexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

// toml dosyası kıymetli. çünkü version artışlarını
// devopsa bağlamak isteyebiliriz. her bir release buildi çıakrken kütüphane repolara baksın ve
// günceli varsa otomatik update etsin ve testleri koşssun sorun yoksa otomatik güncellesin
// toml'da bunu yapmak kolay oluyor.