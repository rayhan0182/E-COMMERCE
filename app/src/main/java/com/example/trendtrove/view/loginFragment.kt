package com.example.trendtrove.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.trendtrove.R
import com.example.trendtrove.core.DataState
import com.example.trendtrove.data.models.login.Login
import com.example.trendtrove.databinding.FragmentLoginBinding
import com.example.trendtrove.fragment.BaseFragment
import com.example.trendtrove.isempty
import com.example.trendtrove.vmodel.VieModel
import kotlin.getValue

 class loginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewmdell : VieModel by viewModels()
     override fun usercreate() {

        with(binding){

            clickSave.setOnClickListener {

                if (!email.isempty()&&!pass.isempty()){

                    val user = Login(email.text.toString(),pass.text.toString())

                    viewmdell.userlogin(user)

                }


            }

            NoAcc.setOnClickListener {

                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)

            }

        }


     }

     override fun userrespons() {

         viewmdell.loginlivedata.observe(viewLifecycleOwner){

             when(it){
                 is DataState.Error ->{

                     progress.dismiss()

                     Toast.makeText(context,"${it.massage}", Toast.LENGTH_LONG).show()

                 }
                 is DataState.Loading ->{

                     progress.show()

                     Toast.makeText(context,"Loading", Toast.LENGTH_LONG).show()

                 }
                 is DataState.Success ->{

                     progress.dismiss()

                     Toast.makeText(context,"successful Created:${it.udata}", Toast.LENGTH_LONG).show()

                     findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)

                 }
             }


         }


     }


 }

