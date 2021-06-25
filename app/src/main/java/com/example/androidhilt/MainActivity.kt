package com.example.androidhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //field injection
    @Inject
    lateinit var someClass: SomeClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
        println(someClass.dothing())
    }
}

class  SomeClass
@Inject constructor(
    private val someOtherClass: SomeOtherClass
){
    fun doAThing():String{
        return "Look I did a thing!"
    }

    fun dothing():String{
        return someOtherClass.doSomeOtherThing()
    }
}

class SomeOtherClass @Inject constructor(){
    fun doSomeOtherThing():String{
        return "Look i did some other thing!"
    }
}