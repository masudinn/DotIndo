package com.masudin.dotindo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.masudin.dotindo.galeri.GalleryFragment
import com.masudin.dotindo.list.ListFragment
import com.masudin.dotindo.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var navigate = findViewById<BottomNavigationView>(R.id.nav)
        var frame = findViewById<FrameLayout>(R.id.content)
        val fragmentList = ListFragment()
        firstRunFragment(fragmentList)

        val mOnNavigate = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_list -> {
                    val fragment = ListFragment()
                    firstRunFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_galeri -> {
                    val fragment = GalleryFragment()
                    firstRunFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profile -> {
                    val fragment = ProfileFragment()
                    firstRunFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        navigate.setOnNavigationItemSelectedListener(mOnNavigate)
    }

    private fun firstRunFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .commit()
    }

}