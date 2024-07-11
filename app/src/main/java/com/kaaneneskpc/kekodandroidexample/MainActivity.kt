package com.kaaneneskpc.kekodandroidexample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "OnCreate")
        setContentView(R.layout.activity_main)

        /* val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        lifecycle.addObserver(CameraComponent())
        lifecycle.addObserver(CameraComponent2()) // component artık lifecycle aware */
    }

    /* override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "OnResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "OnStop")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "OnPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "OnDestroy")
        lifecycle.removeObserver(CameraComponent())
        lifecycle.removeObserver(CameraComponent2()) // component artık lifecycle aware değil.
    }

    /* override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        /* val edtUserField = findViewById<EditText>(R.id.editTxt)
        val userField = edtUserField.text.toString()
        outState.putString("userField", userField) */
        Log.i("MainActivity", "OnSaveInstanceState")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        /* val userField = savedInstanceState.getString("userField")
        val edtUserField = findViewById<EditText>(R.id.editTxt)
        edtUserField.setText(userField) */

        Log.i("MainActivity", "OnRestoreInstanceState")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.i("MainActivity", "OnBackPressed")
        finish()
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        Log.i("MainActivity", "OnUserLeaveHint")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.i("MainActivity", "onLowMemory")
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        Log.i("MainActivity", "onUserInteraction")
    }



    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Log.i("MainActivity", "onWindowFocusChanged")
    }

    override fun onContentChanged() {
        super.onContentChanged()
        Log.i("MainActivity", "onContentChanged")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.i("MainActivity", "onAttachedToWindow")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.i("MainActivity", "onDetachedFromWindow")
    } */
 */

}

// toml dosyası kıymetli. çünkü version artışlarını
// devopsa bağlamak isteyebiliriz. her bir release buildi çıakrken kütüphane repolara baksın ve
// günceli varsa otomatik update etsin ve testleri koşssun sorun yoksa otomatik güncellesin
// toml'da bunu yapmak kolay oluyor.