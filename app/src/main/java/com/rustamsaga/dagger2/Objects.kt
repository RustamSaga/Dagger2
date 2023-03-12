package com.rustamsaga.dagger2

class Processor {
    override fun toString(): String = "AB2023"
}

class Motherboard {
    override fun toString(): String = "X7 3023"
}

class RAM {
    override fun toString(): String = "32 GB"
}

data class Computer(
    val processor: Processor,
    val motherboard: Motherboard,
    val ram: RAM
)