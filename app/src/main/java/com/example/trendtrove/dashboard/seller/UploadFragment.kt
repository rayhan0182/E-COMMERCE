package com.example.trendtrove.dashboard.seller
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.trendtrove.R
import com.example.trendtrove.databinding.FragmentUploadBinding
import com.example.trendtrove.extrasyn
import com.example.trendtrove.fragment.BaseFragment
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.trendtrove.permissiongranted
import com.example.trendtrove.requestpermission
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint




@AndroidEntryPoint
class UploadFragment : BaseFragment<FragmentUploadBinding>(

    FragmentUploadBinding::inflate

) {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun usercreate() {

        binding.apply {

            requestpermissionss = permissionlist()

            imageview.setOnClickListener {

                requestpermission(requestpermissionss,perlist)

            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun permissionlist(): ActivityResultLauncher<Array<String>> {

       return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){

           if (permissiongranted(perlist)){

               Toast.makeText(requireContext(),"permission granted", Toast.LENGTH_LONG).show()

               ImagePicker.with(this)
                   .compress(1024)         //Final image size will be less than 1 MB(Optional)
                   .maxResultSize(512, 512)  //Final image resolution will be less than 1080 x 1080(Optional)
                   .createIntent { intent ->
                       startForProfileImageResult.launch(intent)
                   }

           }else{

               Toast.makeText(requireContext(),"Not all Permission are granted ", Toast.LENGTH_LONG).show()

           }


       }


    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {

                val fileUri = data?.data!!

                 binding.imageview.setImageURI(fileUri)


            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), "success image create", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Not found", Toast.LENGTH_SHORT).show()
            }
        }


    override fun userrespons() {

    }

    companion object{

        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        private var perlist = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_MEDIA_IMAGES)


    }




   private lateinit var requestpermissionss: ActivityResultLauncher<Array<String>>










}