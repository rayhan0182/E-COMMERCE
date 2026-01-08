package com.example.trendtrove.vmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trendtrove.core.DataState
import com.example.trendtrove.data.models.login.Login
import com.example.trendtrove.data.models.register.Regis
import com.example.trendtrove.data.repo.AuthRepository
import com.google.android.play.core.integrity.r
import com.google.firebase.auth.AuthResult

class VieModel: ViewModel() {
    private val _mutablelivedata  = MutableLiveData<DataState<Regis>>()

     val mutablelivedata: LiveData<DataState<Regis>>  = _mutablelivedata

    private val _mutableloginlivedata = MutableLiveData<DataState<Login>>()

    val loginlivedata: LiveData<DataState<Login>> = _mutableloginlivedata

    fun userregis(regis: Regis){

        _mutablelivedata.postValue(DataState.Loading())

        val repo = AuthRepository()

        repo.registration_create(regis).addOnSuccessListener {

            _mutablelivedata.postValue(DataState.Success(regis))

        }.addOnFailureListener {error->

            _mutablelivedata.postValue(DataState.Error(error.message))

        }

    }

    fun userlogin(login: Login){

        _mutableloginlivedata.postValue(DataState.Loading())

        val repo = AuthRepository()

        repo.login_create(login).addOnSuccessListener {

            _mutableloginlivedata.postValue(DataState.Success(login))

        }.addOnFailureListener {error->

            _mutableloginlivedata.postValue(DataState.Error(error.message))

        }



    }

}