package com.example.gymapp.present

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.gymapp.R
import com.example.gymapp.databinding.BackScreenBinding


class BackScreen:AppCompatActivity() {

    lateinit var binding: BackScreenBinding
    private lateinit var inAnimation: Animation
    private lateinit var outAnimation: Animation
    private val viewModel: FragmentViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BackScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inAnimation = AnimationUtils.loadAnimation(this, R.anim.fire_view_start)
        outAnimation = AnimationUtils.loadAnimation(this, R.anim.fire_anim_stop)

        val intent = Intent(this, FrontScreen::class.java)

        binding.buttonToFrontActivity.setOnClickListener {
            startActivity(intent)
        }

        val buttonChestL = binding.buttonAssLeft
        val chestPicture = R.drawable.ass
        val shoulderPicture = R.drawable.shoulder
        val bicepsPicture = R.drawable.biceps

        viewModel.message.value = "Ass"
        viewModel.pictureSent.value = chestPicture
        //viewModel.mainMessage.value = "Chest"

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentLayout, ChestFragment())
            .commit()

    }
}