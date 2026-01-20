package com.example.trendtrove.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trendtrove.R
import com.example.trendtrove.databinding.FragmentDashboardBinding
import com.example.trendtrove.fragment.BaseFragment
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class dashboardFragment : BaseFragment<FragmentDashboardBinding>(

    FragmentDashboardBinding::inflate

) {

    @Inject

    lateinit var auth: FirebaseAuth

    override fun usercreate() {

        with(binding){

            logout.setOnClickListener {

                auth.signOut()

                findNavController().navigate(R.id.action_dashboardFragment_to_startFragment)

            }


        }

    }

    override fun userrespons() {

    }




}