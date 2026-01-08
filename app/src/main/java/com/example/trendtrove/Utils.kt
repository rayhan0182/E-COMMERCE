package com.example.trendtrove

import android.widget.EditText

fun EditText.isempty(): Boolean{

   return if (this.text.toString().isEmpty()){

        this.error  = "Please Enter a value"

        true

    }else{

        false

    }


}