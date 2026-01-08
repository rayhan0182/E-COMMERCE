package com.example.trendtrove.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

@Suppress("DEPRECATION")
abstract class BaseFragment<VB: ViewBinding>(
     private var layoutinflaterr:(inflater: LayoutInflater)->VB
 ): Fragment() {

       private var _binding:VB? = null

       lateinit var progress: ProgressDialog

     val binding:VB get() = _binding as VB

     override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {

         progress = ProgressDialog(requireContext())

         _binding = layoutinflaterr.invoke(inflater)



          usercreate()

         userrespons()




         return binding.root
     }

   abstract fun usercreate()

  abstract fun userrespons()


}