package com.shopx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var navView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.cartFragment, R.id.myFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView?.setupWithNavController(navController)
        // 购物车数量

        navView?.setOnNavigationItemSelectedListener { item ->
           when(item.itemId){
               R.id.homeFragment -> {
                   addCartBadge(-10)
                   true
               }
               R.id.cartFragment -> {
                   addCartBadge(100)
                   true
               }
               R.id.myFragment -> {
                   addCartBadge(90)
                   true
               }
               else -> false
           }
        }

    }


    fun addCartBadge(num: Int) {
        //为cartFragment 创建 badge
        val cartBadgeDrawable = navView?.getOrCreateBadge(R.id.cartFragment)
        if (num > 0) {
            cartBadgeDrawable?.number = num
        } else {
            navView?.removeBadge(R.id.cartFragment)
        }

    }
}