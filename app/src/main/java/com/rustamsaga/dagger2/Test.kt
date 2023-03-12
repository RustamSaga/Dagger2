package com.rustamsaga.dagger2

fun main(){
    val aPpComponent = DaggerAPpComponent.create()
    val computer = aPpComponent.computer

    println(computer)
}