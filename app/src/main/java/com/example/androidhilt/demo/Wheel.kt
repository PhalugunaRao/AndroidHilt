package com.example.androidhilt.demo

import javax.inject.Inject

class Wheel {
    @Inject
    constructor()
    fun getWheel(){
        println("===getWheel===")
    }
}