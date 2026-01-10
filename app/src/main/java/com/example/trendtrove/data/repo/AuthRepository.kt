package com.example.trendtrove.data.repo

import com.example.trendtrove.data.models.login.Login
import com.example.trendtrove.data.models.register.Regis
import com.example.trendtrove.service.Authservice
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthRepository @Inject constructor(private val auth: FirebaseAuth) : Authservice {
    override fun registration_create(regis: Regis): Task<AuthResult> {

        return auth.createUserWithEmailAndPassword(regis.email, regis.password)

    }

    override fun login_create(login: Login): Task<AuthResult> {


        return auth.signInWithEmailAndPassword(login.email, login.password)

    }
}