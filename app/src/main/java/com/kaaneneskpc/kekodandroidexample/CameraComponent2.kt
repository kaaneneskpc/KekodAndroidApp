package com.kaaneneskpc.kekodandroidexample

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class CameraComponent2: LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_RESUME -> startCamera()
            Lifecycle.Event.ON_STOP -> stopCamera()
            else -> {}
        }
    }

    private fun startCamera() {
        Log.e("CameraComponent2", "startCamera")
    }

    private fun stopCamera() {
        Log.e("CameraComponent2", "stopCamera")
    }


}