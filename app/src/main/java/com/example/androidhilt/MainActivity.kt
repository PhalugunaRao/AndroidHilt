package com.example.androidhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

class SomeClass
@Inject
constructor(
    private val someInterfaceImpl: SomeInterface
){
    fun doAThing(): String{
        return "Look I got: ${someInterfaceImpl.getAthing()}"
    }
}

class SomeInterfaceImpl
@Inject
constructor():SomeInterface{
    override fun getAthing(): String {
        return "A Thing"
    }
}

interface SomeInterface{
    fun getAthing():String
}

