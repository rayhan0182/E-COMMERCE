package com.example.trendtrove.dashboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.trendtrove.R
import com.example.trendtrove.databinding.ActivityDashBinding

class DashActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragmentview)

        val appbarconfig = AppBarConfiguration(setOf(

             R.id.productuser,

             R.id.uploaduser,

             R.id.profileuser
        ))

         binding.btmnavigation.setupWithNavController(navController)

         setupActionBarWithNavController(navController,appbarconfig)



    }
}