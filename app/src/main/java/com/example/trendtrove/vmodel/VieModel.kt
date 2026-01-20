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
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class VieModel @Inject constructor(private val authins: FirebaseAuth,private val repo: AuthRepository) : ViewModel() {

    private val _mutablelivedata  = MutableLiveData<DataState<Regis>>()

     val mutablelivedata: LiveData<DataState<Regis>>  = _mutablelivedata

    private val _mutableloginlivedata = MutableLiveData<DataState<Login>>()

    val loginlivedata: LiveData<DataState<Login>> = _mutableloginlivedata

    fun userregis(regis: Regis){

        _mutablelivedata.postValue(DataState.Loading())

        repo.registration_create(regis).addOnSuccessListener {

            it.user?.let {usercreated->

                regis.userId = usercreated.uid

               repo.firestorecreate(regis).addOnSuccessListener {

                   _mutablelivedata.postValue(DataState.Success(regis))

               }.addOnFailureListener {exception ->

                   _mutablelivedata.postValue(DataState.Error(exception.message.toString()))

               }

            }



        }.addOnFailureListener {exception ->

            _mutablelivedata.postValue(DataState.Error(exception.message.toString()))

        }

    }

    fun userlogin(login: Login){

        _mutableloginlivedata.postValue(DataState.Loading())

        repo.login_create(login).addOnSuccessListener {

            _mutableloginlivedata.postValue(DataState.Success(login))

        }.addOnFailureListener {error->

            _mutableloginlivedata.postValue(DataState.Error(error.message))

        }



    }

}