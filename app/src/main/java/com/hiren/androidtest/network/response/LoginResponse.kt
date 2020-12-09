package com.hiren.androidtest.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hiren.androidtest.database.entities.User

class LoginResponse  {

    @SerializedName("errorCode")
    @Expose
    private var errorCode: String = ""

    @SerializedName("errorMessage")
    @Expose
    private var errorMessage: String = ""

    @SerializedName("user")
    private var userData: User = User()

    fun getUserData(): User {
        return userData
    }

    fun setUserData(data: User) {
        userData = data
    }

    open fun getErrorCode(): String {
        return errorCode
    }

    open fun setErrorCode(errorCode: String) {
        this.errorCode = errorCode
    }

    open fun getMessage(): String {
        return errorMessage
    }

    open fun setErrorMessage(errorMessage: String) {
        this.errorMessage = errorMessage
    }
}