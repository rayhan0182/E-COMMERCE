package com.example.trendtrove.starter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trendtrove.R
import com.example.trendtrove.databinding.FragmentStartBinding
import com.example.trendtrove.fragment.BaseFragment
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class startFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {

    @Inject

    lateinit var auth: FirebaseAuth

    override fun usercreate() {

        userlogincheak()



        with(binding) {


            logIn.setOnClickListener {

                findNavController().navigate(R.id.action_startFragment_to_loginFragment)

            }

            signUp.setOnClickListener {

                findNavController().navigate(R.id.action_startFragment_to_registrationFragment)


            }


        }

    }

    private fun userlogincheak() {

        auth.currentUser?.let {

            findNavController().navigate(R.id.action_startFragment_to_dashboardFragment)

        }


    }

    override fun userrespons() {

    }


}