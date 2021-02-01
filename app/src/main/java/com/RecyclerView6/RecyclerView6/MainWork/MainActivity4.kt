package com.RecyclerView6.RecyclerView6.MainWork

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.RecyclerView6.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val navView : BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfig = AppBarConfiguration(setOf(
                R.id.mainActivity, R.id.personActivity))

        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)





    }
}