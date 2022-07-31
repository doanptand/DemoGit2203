package com.ddona.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddona.wallpaper.databinding.ActivityMainBinding
import com.ddona.wallpaper.fragments.WallpaperFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val currentFragment
        get() = supportFragmentManager.findFragmentById(R.id.content)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}