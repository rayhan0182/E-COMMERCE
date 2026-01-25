package com.example.trendtrove.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
import com.example.trendtrove.starter.MainActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashActivity : AppCompatActivity() {

    @Inject
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding: ActivityDashBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragmentview)

        val appbarconfig = AppBarConfiguration(
            setOf(

                R.id.productuser,

                R.id.uploaduser,

                R.id.profileuser
            )
        )

        binding.btmnavigation.setupWithNavController(navController)

        setupActionBarWithNavController(navController, appbarconfig)

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.topmenu, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.report -> {

                Toast.makeText(this, "repot working", Toast.LENGTH_LONG).show()

            }

            R.id.setting -> {

                Toast.makeText(this, "setting working", Toast.LENGTH_LONG).show()

            }

            R.id.logout -> {

                firebaseAuth.signOut()

               startActivity(Intent(this, MainActivity::class.java))

               finish()

            }


        }


        return super.onOptionsItemSelected(item)


    }

}