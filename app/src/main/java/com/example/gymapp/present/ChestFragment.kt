package com.example.gymapp.present

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.gymapp.R
import com.example.gymapp.databinding.ChestFragmentBinding

class ChestFragment : Fragment() {

    private val viewModel:FragmentViewModel by activityViewModels()
    lateinit var  binding:ChestFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ChestFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.message.observe(activity as LifecycleOwner,
            { binding.fragmentTextiew.text = it })

        viewModel.mainMessage.observe(activity as LifecycleOwner,
            { binding.fragmentDescription.text = it })


        viewModel.pictureSent.observe(activity as LifecycleOwner,
            { binding.imageView2.setImageResource(it)})

    }


    companion object {
        @JvmStatic
        fun newInstance() = ChestFragment()
    }

}

