package com.example.androidhilt.demo

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Singleton

interface One{
    fun getName()
}
class ImplementOne @Inject constructor(private val name:String):One{
    override fun getName() {
        println("======my name is $name")
    }

}
class Main @Inject constructor(private val one: One){
    fun getName(){
        one.getName()
    }

}

/*
@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule{
    @Binds
    @Singleton
    abstract fun binding(implementOne: ImplementOne):One

}*/
@Module
@InstallIn(ApplicationComponent::class)
class AppModule{

    @Provides
    @Singleton
    fun getName():String="Geethika"

    @Provides
    @Singleton
    fun binding(
        name:String
    ):One = ImplementOne(name)
}