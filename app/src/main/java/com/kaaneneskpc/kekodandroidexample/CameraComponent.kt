package com.kaaneneskpc.kekodandroidexample

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class CameraComponent: DefaultLifecycleObserver {
    //Bazı componentler lifecycle aware olmalı bu yapıyı kullanıyoruz.
    // 2 kullanım arasında önemli bir fark yok.
    // lifecycle aware demek ana activity yada fragmentın lifecyclenı takip etmesi yeteneğe sahip olmuş yapılardır.

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        startCamera()
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        stopCamera()
    }

    private fun startCamera() {
        Log.e("CameraComponent", "startCamera")
    }

    private fun stopCamera() {
        Log.e("CameraComponent", "stopCamera")
    }
}