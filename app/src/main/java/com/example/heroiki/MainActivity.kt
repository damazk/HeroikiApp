package com.example.heroiki

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.heroiki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    private lateinit var navController: NavController
//    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var listener: NavController.OnDestinationChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setting Toolbar
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayShowHomeEnabled(true)

            navView.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.allHeroesFragment -> Toast.makeText(applicationContext, "All heroes", Toast.LENGTH_SHORT).show()
                    R.id.favHeroesFragment -> Toast.makeText(applicationContext, "Favorite heroes", Toast.LENGTH_SHORT).show()
                    R.id.settingsFragment -> Toast.makeText(applicationContext, "Settings", Toast.LENGTH_SHORT).show()
                }
                true
            }
        }

        navController = findNavController(R.id.fragmentContainerView)
        val appBarConfig = AppBarConfiguration.Builder(navController.graph).setDrawerLayout(binding.drawerLayout).build()
        NavigationUI.setupWithNavController(binding.navView, navController)
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfig)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            true
        }

        return super.onOptionsItemSelected(item)
    }
}