package com.example.trendtrove.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.trendtrove.core.DataState
import com.example.trendtrove.R
import com.example.trendtrove.data.models.register.Regis
import com.example.trendtrove.databinding.FragmentRegistrationBinding
import com.example.trendtrove.fragment.BaseFragment
import com.example.trendtrove.isempty
import com.example.trendtrove.vmodel.VieModel
import kotlin.getValue
//Hair order  function
class registrationFragment : BaseFragment<FragmentRegistrationBinding>(FragmentRegistrationBinding::inflate) {
    private val modells : VieModel by viewModels()


    override fun usercreate() {

        with(binding){

            regBtn.setOnClickListener {

                if (!name.isempty()&&!email.isempty()&&!pass.isempty()){

                    val userdata = Regis(name.text.toString(),email.text.toString()

                        ,pass.text.toString(),"seller","")

                    modells.userregis(userdata)

                }

            }

            haveAcc.setOnClickListener {

                findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)

            }

        }

    }

    override fun userrespons() {

        modells.mutablelivedata.observe(viewLifecycleOwner){

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

                }
            }


        }


    }


}