package com.subha.mytrackerapplication.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

import com.subha.mytrackerapp.util.Constants.ACTION_PAUSE_SERVICE
import com.subha.mytrackerapp.util.Constants.ACTION_START_OR_RESUME_SERVICE
import com.subha.mytrackerapp.util.Constants.ACTION_STOP_SERVICE

import timber.log.Timber

class TrackingService : Service() {

    init {
        Log.d("vghg", "service running")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    Timber.d("Started or resumed service")
                }
                ACTION_PAUSE_SERVICE -> {
                    Timber.d("Paused service")
                }
                ACTION_STOP_SERVICE -> {
                    Timber.d("Stopped service")
                }
            }
        }
        return  super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("vghg", "Service killed")
    }

    override fun onBind(intent: Intent?): IBinder? = null
}