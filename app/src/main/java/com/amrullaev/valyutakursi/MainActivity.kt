package com.amrullaev.valyutakursi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.amrullaev.valyutakursi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.menuIcon.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                1 -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }

            }
            return@setNavigationItemSelectedListener true
        }
        val navController = findNavController(R.id.navigationView)
        binding.navView.setupWithNavController(navController)


        val navController1 = findNavController(R.id.navigationView)
        binding.bottomView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.homeFragment, R.id.allCurseFragment, R.id.calcFragment -> {
                    binding.bottomView.visibility = View.VISIBLE
                }

                else -> binding.bottomView.visibility = View.GONE
            }
        }
    }
}