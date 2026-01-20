package com.example.trendtrove.service

import com.example.trendtrove.data.models.login.Login
import com.example.trendtrove.data.models.register.Regis
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface Authservice {

    fun registration_create(regis: Regis): Task<AuthResult>

    fun login_create(login: Login): Task<AuthResult>

    fun firestorecreate(regis: Regis): Task<Void>

}