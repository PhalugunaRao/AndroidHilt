package com.example.androidhilt.demo

import javax.inject.Inject

class Car @Inject constructor(private val engine: Engine,
                              private val wheel:Wheel){

    fun getCar(){
        engine.getEngine()
        wheel.getWheel()
        println("=====car is running===")
    }
}