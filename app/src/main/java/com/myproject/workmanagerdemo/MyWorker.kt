package com.myproject.workmanagerdemo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {


    override fun doWork(): Result {
/*
Receiving the data from activity
 */
       println("************ worker thread is   " +Thread.currentThread())
        val data  = inputData
        val desc = data.getString("inputData")
        displayNotifications("My First Notification", desc!!)

        /*
        we can send data to the the component which started this worker class
         */
        val senderData = Data.Builder()
            .putString("successTag", "Task Completed successfully.")
            .build()

        return Result.success(senderData)
    }

    private fun displayNotifications(task: String, desc: String){

        val manager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
           val channel = NotificationChannel("WMNotification", "First Notification", NotificationManager.IMPORTANCE_DEFAULT )
            manager.createNotificationChannel(channel)
        }
        val builder = NotificationCompat
            .Builder(applicationContext, "WMNotification")
            .setContentTitle(task)
            .setContentText(desc)
            .setSmallIcon(R.mipmap.ic_launcher)

        manager.notify(1, builder.build())

    }

}