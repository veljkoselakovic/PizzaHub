package com.example.pizzacompare

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzacompare.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.pizza.pizzacompare.Pizza


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonCompare.setOnClickListener { comparePizzas() }
        MobileAds.initialize(
            this
        ) { }
        val mAdView = binding.adView
        val adRequest: AdRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }


    private fun comparePizzas()  {
        var pizza1Diameter = binding.pizza1Diameter.text?.toString()?.toDouble()
        if (pizza1Diameter == null) {
            pizza1Diameter = 0.0
        }
        var pizza1Price = binding.pizza1Price.text?.toString()?.toDouble()
        if(pizza1Price == null){
            pizza1Price = 0.0
        }
        var pizza2Diameter = binding.pizza2Diameter.text?.toString()?.toDouble()
        if (pizza2Diameter == null) {
            pizza2Diameter = 0.0
        }
        var pizza2Price = binding.pizza2Price.text?.toString()?.toDouble()
        if(pizza2Price == null){
            pizza2Price = 0.0
        }


        val pizza1 : Pizza = Pizza(pizza1Diameter,
            "Capricciosa",
            pizza1Price)
        val pizza2 : Pizza = Pizza(pizza2Diameter,
            "Capricciosa",
            pizza2Price)

        var pizza1Amount = binding.pizza1Amount.text?.toString()?.toInt()
        if (pizza1Amount == null) pizza1Amount = 0
        var pizza2Amount = binding.pizza2Amount.text?.toString()?.toInt()
        if (pizza2Amount == null) pizza2Amount = 0
        val pizza1Area = pizza1.getArea() * pizza1Amount
        val pizza2Area = pizza2.getArea() * pizza2Amount

        var biggestArea: Double
        var biggestAreaName: String
        if (pizza1Area > pizza2Area){
            biggestArea = pizza1Area
            biggestAreaName = "Pizza #1"
        }
        else{
            biggestArea = pizza2Area
            biggestAreaName = "Pizza #2"
        }
        var cheapestPizza: Double
        var cheapestPizzaName: String

        if(pizza1Price * pizza1Amount > pizza2Price * pizza2Amount){
            cheapestPizza = pizza2Price * pizza2Amount
            cheapestPizzaName = "Pizza #2"

        }
        else if (pizza1Price * pizza1Amount == pizza2Price * pizza2Amount){
            cheapestPizza = pizza1Price * pizza1Amount
            cheapestPizzaName = biggestAreaName
        }
        else {
            cheapestPizza = pizza1Price * pizza1Amount
            cheapestPizzaName = "Pizza #1"
        }
        //Log.d("MainActivity", "!____" + pizza1Amount.toString() + pizza1.price.toString() + cheapestPizza.toString())
        binding.comparedPizzasMoney.text = getString(R.string.pizza_compare_money, cheapestPizzaName, cheapestPizza)
        binding.comparedPizzasSize.text = getString(R.string.pizza_compare_size, biggestAreaName, biggestArea, getString(R.string.measurement))


    }
}