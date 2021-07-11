package com.example.androidhilt.demo

import javax.inject.Inject

class Engine {
    @Inject
    constructor()
    fun getEngine(){
        println("====getEngine===")
    }
}