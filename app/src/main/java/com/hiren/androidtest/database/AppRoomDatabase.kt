package com.jigar.kotlin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hiren.androidtest.database.entities.User
import com.hiren.androidtest.database.UserDao

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
