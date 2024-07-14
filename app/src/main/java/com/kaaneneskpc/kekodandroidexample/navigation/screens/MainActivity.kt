package com.kaaneneskpc.kekodandroidexample.navigation.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.kaaneneskpc.kekodandroidexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "OnCreate")
        setContentView(R.layout.activity_main)

        /* getNavControllerViaFragment()
         getNavControllerViaFragment2()
         getNavControllerViaView()
          getNavControllerViaFragment3()//Run truely

         getNavControllerViaView2()  //Error -> does not have a NavController set (NavController'a erişim sorunu var demektir)
         // Burda fragment'ın kendisi yok view var onun da NavHostFragment'ı olmadığı için create anında cast ettirmemiz gerekir. */
        // getNavControllerViaView3() Error -> does not have an NavController

    }

    private fun getNavControllerViaFragment() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

    }

    private fun getNavControllerViaFragment2() {
        val navHostFragmentView =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentContainer) as NavHostFragment
        val navControllerView = navHostFragmentView.navController
    }

    private fun getNavControllerViaFragment3() {
        findNavController(R.id.navHostFragment)
    }

    private fun getNavControllerViaView() {
        val navHostFragmentView = findViewById<View>(R.id.navHostFragment)
        val navControllerView = navHostFragmentView.findNavController()
    }

    private fun getNavControllerViaView2() {
        val navHostFragmentView =
            findViewById<View>(R.id.navHostFragmentContainer) // as NavHostFragment yaparsak onResume'da bile
        // hata alır view'ı fragment'a cast etmek için support Fragment ile bunun bir fragment olduğunu belirtmemiz gerek.
        val navControllerView = navHostFragmentView.findNavController()
    }

    private fun getNavControllerViaView3() {
        findNavController(R.id.navHostFragmentContainer)
    }

    override fun onResume() {
        super.onResume()
        // getNavControllerViaView2()
        // getNavControllerViaView3() onResume'da çağrılabilir ama onCreate'de çağırınca hata veriyor. Controller'a sahip olmadğı için
    }

}

// toml dosyası kıymetli. çünkü version artışlarını
// devopsa bağlamak isteyebiliriz. her bir release buildi çıakrken kütüphane repolara baksın ve
// günceli varsa otomatik update etsin ve testleri koşssun sorun yoksa otomatik güncellesin
// toml'da bunu yapmak kolay oluyor.

//    navHostFragment.navController
//    navHostFragment.findNavController() -> Yukarıdaki ile aynı değil yukarıdaki NavHostFragment'ın
//    variable'ı iken alttaki view'ın extension functionu

//    navControllerSet ile alakalı hata onResume'da çalışması gerek  typecast hatası o tamamen yanlış işlemdir.