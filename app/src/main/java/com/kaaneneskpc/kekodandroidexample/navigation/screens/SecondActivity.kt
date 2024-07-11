package com.kaaneneskpc.kekodandroidexample.navigation.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaaneneskpc.kekodandroidexample.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /* val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        } */

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
    }

    override fun onSaveInstanceState(outState: Bundle) {
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
}