package com.hiren.androidtest.network

import com.hiren.androidtest.network.request.LoginRequest
import com.hiren.androidtest.network.response.LoginResponse
import io.reactivex.Single

interface AuthApiInterface {
    fun userLogin(request: LoginRequest): Single<LoginResponse>
}