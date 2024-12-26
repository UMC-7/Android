package com.example.foregroundservice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class Foreground : Service() {

    val CHANNEL_ID = "1"
    val NOTI_ID = 2
    private val handler = Handler(Looper.getMainLooper())
    private var progress = 0
    private var isRunning = false // 서비스가 실행 중인지 여부를 나타내는 변수

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(CHANNEL_ID, "FOREGROUND", NotificationManager.IMPORTANCE_HIGH)
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()

        // MainActivity로 이동하는 Intent 생성
        val activityIntent = Intent(this, MainActivity::class.java)
        activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            activityIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        if (!isRunning) {
            isRunning = true
            runBackground()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    fun runBackground() {
        // 주기적인 작업을 Handler로 처리
        handler.post(object : Runnable {
            override fun run() {
                if (progress <= 100 && isRunning) { // isRunning이 true일 때만 계속 진행
                    // 알림의 시크바 업데이트
                    val notification = NotificationCompat.Builder(this@Foreground, CHANNEL_ID)
                        .setContentTitle("Foreground")
                        .setContentText("Progressing... $progress%")
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentIntent(getPendingIntent())
                        .setProgress(100, progress, false) // 시크바 진행
                        .setAutoCancel(true)
                        .build()

                    // 알림 업데이트
                    val notificationManager = getSystemService(NotificationManager::class.java)
                    notificationManager.notify(NOTI_ID, notification)

                    Log.d("서비스", "COUNT => $progress")
                    progress++

                    // 1초마다 작업을 반복 (주기적으로)
                    handler.postDelayed(this, 1000)
                }
            }
        })
    }

    private fun getPendingIntent(): PendingIntent {
        // MainActivity로 이동하는 PendingIntent
        val activityIntent = Intent(this, MainActivity::class.java)
        activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        return PendingIntent.getActivity(
            this,
            0,
            activityIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    override fun onBind(intent: Intent): IBinder {
        return Binder()
    }

    // 서비스 종료를 위한 메서드
    override fun onDestroy() {
        super.onDestroy()
        isRunning = false // 서비스가 종료되면 주기적인 작업을 멈추기 위해 false로 설정
        handler.removeCallbacksAndMessages(null) // 모든 handler 작업 취소
    }
}
