package com.example.androidhilt.demo

import javax.inject.Inject

class Car {
    @Inject
    constructor()
    fun getCar(){
        println("=====car is running===")
    }
}