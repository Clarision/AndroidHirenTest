package com.hiren.androidtest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hiren.androidtest.database.entities.User
import io.reactivex.Single

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: User)

    @Query("SELECT *  FROM user LIMIT 1")
    fun getLoggedUserData(): Single<User>

}