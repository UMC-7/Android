package com.example.myapplication

import android.app.Activity
import android.app.FragmentContainer
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentcon) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomnav.setupWithNavController(navController)

        binding.bottomnav.setOnItemSelectedListener { item ->
            val navOptionsLeftToRight = NavOptions.Builder()
                .setEnterAnim(R.anim.to_right)
                .setExitAnim(R.anim.from_right)
                .setPopEnterAnim(R.anim.to_left)
                .setPopExitAnim(R.anim.from_left)
                .build()

            val navOptionsRightToLeft = NavOptions.Builder()
                .setEnterAnim(R.anim.to_left)
                .setExitAnim(R.anim.from_left)
                .setPopEnterAnim(R.anim.to_right)
                .setPopExitAnim(R.anim.from_right)
                .build()

            when (item.itemId) {
                R.id.item_search_img -> {
                    navController.navigate(R.id.item_search_img, null, navOptionsRightToLeft)
                    true
                }

                R.id.item_home_img -> {
                    // search에서 home으로 이동 시 오른쪽에서 왼쪽으로 애니메이션
                    if (binding.bottomnav.selectedItemId == R.id.item_search_img) {
                        navController.navigate(R.id.item_home_img, null, navOptionsLeftToRight)
                    }
                    // setting에서 home으로 이동 시 왼쪽에서 오른쪽으로 애니메이션
                    else if (binding.bottomnav.selectedItemId == R.id.item_setting_img) {
                        navController.navigate(R.id.item_home_img, null, navOptionsRightToLeft)
                    }
                    true
                }

                R.id.item_setting_img -> {
                    navController.navigate(R.id.item_setting_img, null, navOptionsLeftToRight)
                    true
                }
                else -> false
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        /*
        val imageB: ImageView = findViewById(R.id.imageViewB)
        imageB.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        val imageY: ImageView = findViewById(R.id.imageViewY)
        imageY.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val imageP: ImageView = findViewById(R.id.imageViewP)
        imageP.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val imageR: ImageView = findViewById(R.id.imageViewR)
        imageR.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val imageG: ImageView = findViewById(R.id.imageViewG)
        imageG.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        */
    }
    fun hideBottomNavigation(state:Boolean){
        if(state) binding.bottomnav.visibility = View.GONE else binding.bottomnav.visibility=View.VISIBLE
    }
}