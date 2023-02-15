package com.example.mvvmprac

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmprac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel: LikeViewModel by viewModels()

    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        //-- Data binding --
        binding.likeVM = viewModel
        binding.lifecycleOwner = this
        binding.disLikeVM = viewModel
        binding.lifecycleOwner = this

        binding.likeBtn.setOnClickListener {
            viewModel.PerformLike()

        }

        binding.disLikeBtn.setOnClickListener {
            viewModel.PerformDisLike()


        }

    }

    override fun onPause() {
        super.onPause()

        val sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply {
            //putString("LIKE", binding.textViewLikeCount.text.toString())
            putString("LIKE", viewModel.likeCount.value.toString())
            putString("DISLIKE", viewModel.dislikeCount.value.toString())
            apply()
        }

    }

    override fun onResume() {
        super.onResume()
        val sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val load = sharedPref.getString("LIKE", null)
        val load1 = sharedPref.getString("DISLIKE", null)

        binding.textViewLikeCount.setText(load)
        binding.textViewDislikeCount.setText(load1)



    }

}



