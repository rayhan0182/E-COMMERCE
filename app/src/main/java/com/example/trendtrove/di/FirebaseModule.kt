package com.example.trendtrove.di
import com.example.trendtrove.data.repo.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule{

    @Provides
    @Singleton
    fun providerfirebaseauth(): FirebaseAuth{

       return FirebaseAuth.getInstance()

    }


    @Provides

    @Singleton

    fun authrepository(auth: FirebaseAuth,firstore: FirebaseFirestore): AuthRepository{

       return AuthRepository(auth,firstore)

    }

    @Provides

    @Singleton

    fun firestore(): FirebaseFirestore{


       return FirebaseFirestore.getInstance()

    }


}