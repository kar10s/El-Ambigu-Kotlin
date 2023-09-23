package org.carlosrp.elambigukotlin.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import org.carlosrp.elambigukotlin.R
import org.carlosrp.elambigukotlin.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController   //Clase padre que controla toda la navegacion
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initNavigation()
        initAppBarConfiguration()
    }

    private fun initNavigation() {
        val navHost =
            supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment //frg Container in Main
        navController = navHost.navController

        binding.drawerNavView.setupWithNavController(navController)
        binding.bottomNavView.setupWithNavController(navController)
    }

    private fun initAppBarConfiguration() {
        setSupportActionBar(binding.toolbar)
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.layoutDrawer)



        //appBarConfiguration = AppBarConfiguration(navController.graph,binding.layoutDrawer, fallbackOnNavigateUpListener = {true})
        setupActionBarWithNavController(navController, appBarConfiguration)

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
        //return navController.navigateUp(appBarConfiguration)
        //return true
    }
}
