package com.example.trendtrove.data.repo

import com.example.trendtrove.data.models.register.Regis
import com.example.trendtrove.service.Authservice
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthRepository: Authservice {
    override fun registration_create(regis: Regis): Task<AuthResult> {

        val auth = FirebaseAuth.getInstance()

       return auth.createUserWithEmailAndPassword(regis.email,regis.password)

    }
}