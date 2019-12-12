package com.example.plusminuscount

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //declare module-level variable
    private lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize the ViewModel
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        //Add an observer to the ViewModel
        countViewModel.count.observe(this,
            Observer {
                if(it.equals(4)) goodLuck()
            }
        )

        textViewCount.text = countViewModel.count.value.toString()

        buttonDecrease.setOnClickListener {
            countViewModel.decrement()
            textViewCount.text = countViewModel.count.value.toString()
        }

        buttonIncrease.setOnClickListener {
            countViewModel.increment()
            textViewCount.text = countViewModel.count.value.toString()
        }
    }

    private fun goodLuck() {
        Toast.makeText(applicationContext,"what a lucky day!",
            Toast.LENGTH_SHORT).show()
    }
}
