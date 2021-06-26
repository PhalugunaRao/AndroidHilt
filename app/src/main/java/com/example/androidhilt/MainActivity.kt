package com.example.androidhilt

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.solver.widgets.analyzer.Dependency
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
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
constructor(
    private val someDependency: String
):SomeInterface{
    override fun getAthing(): String {
        return "A Thing"
    }
}

interface SomeInterface{
    fun getAthing():String
}


@InstallIn(ApplicationComponent::class)
@Module
class MyModule{

    @Singleton
    @Provides
    fun provideSomeString():String{
        return "some string"
    }
    @Singleton
    @Provides
    fun  provideSomeInterface(
        someString:String
    ):SomeInterface{
        return SomeInterfaceImpl(someString)
    }
}


/*
//Binds
@InstallIn(ApplicationComponent::class)
@Module
abstract class MyModule{
    @Singleton
    @Binds
    abstract  fun bindSomeDependency(
        someImpl:SomeInterfaceImpl
    ):SomeInterface

}*/
















