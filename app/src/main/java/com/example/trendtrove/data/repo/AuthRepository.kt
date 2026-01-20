package com.example.trendtrove.data.repo

import com.example.trendtrove.Nodesuser
import com.example.trendtrove.data.models.login.Login
import com.example.trendtrove.data.models.register.Regis
import com.example.trendtrove.service.Authservice
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AuthRepository @Inject constructor(private val auth: FirebaseAuth,private val firest: FirebaseFirestore) : Authservice {


    override fun registration_create(regis: Regis): Task<AuthResult> {

        return auth.createUserWithEmailAndPassword(regis.email, regis.password)

    }

    override fun login_create(login: Login): Task<AuthResult> {


        return auth.signInWithEmailAndPassword(login.email, login.password)

    }

    override fun firestorecreate(regis: Regis): Task<Void> {

       return firest.collection(Nodesuser.user).document(regis.userId).set(regis)

    }
}