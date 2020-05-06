package com.myproject.workmanagerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Duration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("************ main thread is   " +Thread.currentThread())
        /*
        sending data at runtime to the worker class by using data object
        we can send as many data you want in form of key value pairs
         */
        val data= Data.Builder()
            .putString("inputData","Description is First Notification")
            .build()

//        val  duration:Duration = Duration.ofSeconds(3)
        val workRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setInputData(data)
            .build()
//        val workRequest = PeriodicWorkRequest.Builder(MyWorker::class.java, 10000)

        WMButton.setOnClickListener {
            WorkManager.getInstance(this).enqueue(workRequest)
        }

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workRequest.id)
            .observe(this, Observer {
                /*
                retrieve the output data which we passed from worker class
                 */
                textView.text = it.outputData.getString("successTag")
            })

    }
}
