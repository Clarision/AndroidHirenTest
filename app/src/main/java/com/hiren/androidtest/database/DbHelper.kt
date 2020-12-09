package com.jigar.kotlin.data.local.db

import com.hiren.androidtest.database.entities.User
import io.reactivex.Completable
import io.reactivex.Single

interface DbHelper {

    fun saveUserDB(list: User)
    fun getLoggedUser(): Single<User>
}