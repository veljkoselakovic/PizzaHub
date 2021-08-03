package com.pizza.pizzacompare

class Pizza(
    private val diameter: Double,
    val type: String,
    val price: Double
    ){
    fun getArea() : Double {
        return diameter * diameter * kotlin.math.PI / 4.00
    }
    fun getDiameter() : Double {
        return diameter
    }

}