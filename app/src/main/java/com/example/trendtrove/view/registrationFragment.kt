package com.example.trendtrove.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.trendtrove.DataState
import com.example.trendtrove.data.models.register.Regis
import com.example.trendtrove.databinding.FragmentRegistrationBinding
import com.example.trendtrove.isempty
import com.example.trendtrove.vmodel.VieModel
import kotlin.getValue

class registrationFragment : Fragment() {

    lateinit var binding: FragmentRegistrationBinding
   private val modells : VieModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater,container,false)

        create_regis()

        responsuser()


        return binding.root
    }

    private fun responsuser() {


        modells.mutablelivedata.observe(viewLifecycleOwner){

            when(it){
                is DataState.Error ->{

                    Toast.makeText(context,"$it", Toast.LENGTH_LONG).show()

                }
                is DataState.Loading ->{

                    Toast.makeText(context,"loading", Toast.LENGTH_LONG).show()

                }
                is DataState.Success ->{

                    Toast.makeText(context,"successful user:$it", Toast.LENGTH_LONG).show()

                }
            }


        }


    }

    private fun create_regis() {

        with(binding){

            regBtn.setOnClickListener {

                if (!name.isempty()&&!email.isempty()&&!pass.isempty()){

                    Toast.makeText(context,"all input done", Toast.LENGTH_SHORT).show()

                    val userdata = Regis(name.text.toString(),email.text.toString()

                        ,pass.text.toString(),"seller","")

                    modells.userregis(userdata)


                }


            }



        }

    }


}