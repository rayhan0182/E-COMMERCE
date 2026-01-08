package com.example.trendtrove.starter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trendtrove.R
import com.example.trendtrove.databinding.FragmentStartBinding

class startFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStartBinding.inflate(inflater,container,false)


        clicklistner()



        return binding.root
    }

    private fun clicklistner() {

        with(binding){


            logIn.setOnClickListener {

                findNavController().navigate(R.id.action_startFragment_to_loginFragment)

            }

             signUp.setOnClickListener {

                 findNavController().navigate(R.id.action_startFragment_to_registrationFragment)


             }




        }






    }


}