package com.hiren.androidtest.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
class User {

    @PrimaryKey(autoGenerate = true)
    private var id = 0

    @SerializedName("userId")
    @Expose
    private var userId: String = ""

    @SerializedName("userName")
    @Expose
    private var userName: String = ""

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getUserId(): String {
        return userId
    }

    fun setUserId(userId: String) {
        this.userId = userId
    }

    fun getUserName(): String {
        return userName
    }

    fun setUserName(userName: String) {
        this.userName = userName
    }

}