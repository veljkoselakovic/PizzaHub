package com.pizza.pizzacompare

class Pizza(
    private val diameter: Double,
    val type: String,
    val price: Double
    ){
    fun getArea() : Double {
        return diameter * diameter * kotlin.math.PI
    }
    fun getDiameter() : Double {
        return diameter
    }

}