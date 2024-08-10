package com.kaaneneskpc.diexample


interface Engine {
    fun start()
}

class GasEngine : Engine {
    override fun start() {
        println("Gas Engine started")
    }
}

class ElectricEngine : Engine {
    override fun start() {
        println("Electric Engine started")
    }
}

class HybridEngine : Engine {
    override fun start() {
        println("Hybrid Engine started")
    }
}

class QuantumEngine : Engine {
    override fun start() {
        println("Quantum Engine started")
    }
}

class Car(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

class Plane {
    private lateinit var engine: Engine

    /* private yazılınca set ve get fonksiyonlarını bizim yazmamız gerekiyor encapsulationdan ötürü
    eğer private yapmaz isek sistem kendisi get ve setini ayarlamaya çalışacak ve biz de get ve set
    yazdığımızdan altta ikisi çakışacak ve hata verecek */

    fun setEngine(engine: Engine) {
        this.engine = engine
    }

    fun start() {
        engine.start()
    }
}

fun main() {
    val plane = Plane()
    plane.setEngine(GasEngine())
    plane.start()
}