package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(
                binding.textBoxOne,
                binding.boxTwoText,
                binding.boxThreeText,
                binding.boxFourText,
                binding.boxFiveText,
                binding.ctLayout,
                binding.redButton,
                binding.yellowButton,
                binding.greenButton,
            )
        for (item in clickableViews) {
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View) {
        when (view) {
            // Boxes using Color class colors for background
            binding.textBoxOne -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            binding.boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.greenButton -> binding.boxThreeText.setBackgroundColor(Color.GREEN)
            binding.yellowButton -> binding.boxFourText.setBackgroundColor(Color.YELLOW)
            binding.redButton -> binding.boxFiveText.setBackgroundColor(Color.RED)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}