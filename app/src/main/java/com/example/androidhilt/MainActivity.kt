package com.example.androidhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidhilt.demo.Car
import com.example.androidhilt.demo.Main
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //field injection
    /*@Inject
    lateinit var car: Car
*/

    @Inject
    lateinit var main: Main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //car.getCar()
        main.getName()

    }
}

