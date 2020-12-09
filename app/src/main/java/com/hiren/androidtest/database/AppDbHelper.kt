package com.jigar.kotlin.data.local.db

import com.hiren.androidtest.database.entities.User
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject
constructor(private val appRoomDatabase: AppRoomDatabase){

    fun saveUserDB(user: User) {
        appRoomDatabase.userDao().insert(user)
    }

    fun getLoggedUser(): Single<User> {
        return appRoomDatabase.userDao().getLoggedUserData()
    }

}