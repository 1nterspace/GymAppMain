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
import com.example.gymapp.databinding.FrontScreenBinding


class FrontScreen: AppCompatActivity() {

    lateinit var binding: FrontScreenBinding
    private val viewModel:FragmentViewModel by viewModels()

    private lateinit var inAnimation: Animation
    private lateinit var outAnimation: Animation
    var count: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = FrontScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inAnimation = AnimationUtils.loadAnimation(this, R.anim.fire_view_start)
        outAnimation = AnimationUtils.loadAnimation(this, R.anim.fire_anim_stop)

        val intent = Intent(this, BackScreen::class.java)
        binding.buttonToBackActivity.setOnClickListener {
            startActivity(intent)
        }

        val intent2 = Intent(this, MainActivity::class.java)
        binding.imageViewBack.setOnClickListener {
            startActivity(intent2)
        }

        val buttonChestL = binding.buttonAssLeft
        val buttonChestR = binding.buttonAssRight
        val chestPicture = R.drawable.chest
        val buttonShoulderL = binding.buttonShoulderLeft
        val buttonShoulderR = binding.buttonShoulderRight
        val shoulderPicture = R.drawable.shoulder
        val buttonBicepsL = binding.buttonBicepsLeft
        val buttonBicepsR = binding.buttonBicepsRight
        val bicepsPicture = R.drawable.biceps


        binding.apply {
            clickListener(buttonChestL,fireAnimAsstLeft,fireAnimAssRight,chestPicture, "Chest")
            clickListener(buttonChestR,fireAnimAsstLeft,fireAnimAssRight,chestPicture, "Chest")

            clickListener(buttonShoulderL,fireAnimShouldertLeft,fireAnimBShoulderRight,shoulderPicture,"Shoulders")
            clickListener(buttonShoulderR,fireAnimShouldertLeft,fireAnimBShoulderRight,shoulderPicture,"Shoulders")

            clickListener(buttonBicepsL,fireAnimBicepsLeft,fireAnimBicepsRight,bicepsPicture,"Biceps")
            clickListener(buttonBicepsR,fireAnimBicepsLeft,fireAnimBicepsRight,bicepsPicture,"Biceps")

        }
}

    private fun clickListener(
        button: Button,
        animationLeft: LottieAnimationView,
        animationRight: LottieAnimationView,
        imageId:Int,
        text:String) {
        var count = 0
        binding.apply {
            button.setOnClickListener {
                count++
                binding.apply {
                    animationBinding(animationLeft,count)
                    animationBinding(animationRight,count)
                }
                fragmentBinding(ChestFragment(),count,imageId,text)
            }
        }
    }

    private fun fragmentBinding(
        fragment: ChestFragment,
        count: Int,
        imageId:Int,
        text: String){

        viewModel.message.value = text
        viewModel.pictureSent.value = imageId

        if (count % 2 == 0){
            binding.apply {
                fragmentLayout.startAnimation(outAnimation)
                fragmentLayout.visibility = View.INVISIBLE
            }
        }
        else {
            binding.apply {
                fragmentLayout.startAnimation(inAnimation)
                fragmentLayout.visibility = View.VISIBLE
            }
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentLayout,fragment)
            .commit()
    }

    private fun animationBinding(
        lottieAnimationView: LottieAnimationView,
        count:Int) {

        binding.apply {
            if (count % 2 == 0){
                lottieAnimationView.startAnimation(outAnimation)
                lottieAnimationView.visibility = View.INVISIBLE
            }
            else {
                lottieAnimationView.startAnimation(inAnimation)
                lottieAnimationView.visibility = View.VISIBLE
            }

            lottieAnimationView.repeatCount = LottieDrawable.INFINITE
            lottieAnimationView.repeatMode = LottieDrawable.RESTART
            lottieAnimationView.setMinProgress(0f)
            lottieAnimationView.setMaxProgress(0.65f)
            lottieAnimationView.playAnimation()
        }
    }

    }

