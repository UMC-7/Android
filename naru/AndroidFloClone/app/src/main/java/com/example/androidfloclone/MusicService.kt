package com.example.androidfloclone

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi

class MusicService : Service() {

    companion object {
        private const val TAG = "MusicService"
    }

    override fun onCreate() {
        super.onCreate()
        try {
            createNotificationChannel()
        } catch (e: Exception) {
            Log.e(TAG, "Error creating notification channel: ${e.message}")
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service started")

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                showNotification()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error showing notification: ${e.message}")
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? = null

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showNotification() {
        // 알림을 클릭했을 때 이동할 화면을 지정한다.
        val notificationIntent = Intent(this, SongActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE // FLAG_IMMUTABLE 추가
        )

        val notification = Notification
            .Builder(this, NotificationConstants.CHANNEL_ID)
            .setContentTitle("음악 재생 중")
            .setContentText("현재 음악이 재생 중입니다.")
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(NotificationConstants.NOTIFICATION_ID, notification)
        Log.d(TAG, "Foreground service started with notification")
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                NotificationConstants.CHANNEL_ID, "Music Playback",
                NotificationManager.IMPORTANCE_DEFAULT // IMPORTANCE_DEFAULT로 변경
            )

            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
            Log.d(TAG, "Notification channel created")
        }
    }
}
