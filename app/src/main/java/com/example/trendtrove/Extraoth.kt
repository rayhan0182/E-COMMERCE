package com.example.trendtrove
import android.content.pm.PackageManager
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment


fun EditText.extrasyn(): String{

  return  this.text.toString()

}

fun Fragment.requestpermission(

    request: ActivityResultLauncher<Array<String>>,

    permission: Array<String>

){

    request.launch(permission)

}

fun Fragment.permissiongranted(permissions: Array<String>): Boolean{

   return permissions.all {

       ContextCompat.checkSelfPermission(requireContext(),it)==PackageManager.PERMISSION_GRANTED

    }

}



