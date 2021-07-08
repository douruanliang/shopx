package com.shopx.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shopx.R
import com.shopx.base.BaseActivity

class MainActivity : BaseActivity() {
    var mNavView: BottomNavigationView? = null
    var mNavController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar(true)
        setContentView(R.layout.activity_main)
        //var api: APIService = RetrofitManager.get().create(APIService::class.java)
        initNavigation()
    }

    fun initNavigation() {
        mNavView = findViewById(R.id.nav_view)
        //mNavView?.setItemIconTintList(null) //如果需要 自定义的icon图的话 需要屏蔽掉
        mNavController = findNavController(R.id.nav_host_fragment_activity_main)
        mNavView?.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var selectId = item.itemId
                var currentId = mNavController?.currentDestination?.id
                if (selectId == currentId) return false
                NavigationUI.onNavDestinationSelected(item, mNavController!!)
                return true
            }
        })

    }


    /**
     *     购物车数量
     */
    fun addCartBadge(num: Int) {
        //为cartFragment 创建 badge
        val cartBadgeDrawable = mNavView?.getBadge(R.id.cartFragment)
        if (num > 0) {
            cartBadgeDrawable?.isVisible = true
            cartBadgeDrawable?.number = num
        } else {
            cartBadgeDrawable?.isVisible = false
            cartBadgeDrawable?.clearNumber()
            //navView?.removeBadge(R.id.cartFragment)
        }

    }
}