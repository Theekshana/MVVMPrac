package com.example.mvvmprac

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmprac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel: LikeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()


        //-- Data binding --
        binding.likeVM = viewModel
        binding.lifecycleOwner = this
        binding.disLikeVM = viewModel
        binding.lifecycleOwner = this

        binding.likeBtn.setOnClickListener {
            viewModel.PerformLike()
            editor.apply {
                putString("LIKE", binding.textViewLikeCount.text.toString())
                apply()
            }

        }

        binding.disLikeBtn.setOnClickListener {
            viewModel.PerformDisLike()
            editor.apply {
                putString("DISLIKE", binding.textViewDislikeCount.text.toString())
                apply()
            }

        }

        binding.loadData.setOnClickListener {
            val load = sharedPref.getString("LIKE", null)
            val load1 = sharedPref.getString("DISLIKE", null)
            binding.textViewLikeCount.setText(load)
            binding.textViewDislikeCount.setText(load1)
        }


    }

}


