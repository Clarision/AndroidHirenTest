package com.hiren.androidtest.network

import com.hiren.androidtest.network.request.LoginRequest
import com.hiren.androidtest.network.response.LoginResponse
import com.hiren.androidtest.utility.Constants
import com.rx2androidnetworking.Rx2ANRequest
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthAuthApiClient

@Inject constructor() : AuthApiInterface {

    override fun userLogin(request: LoginRequest): Single<LoginResponse> {
        val rxRequest: Rx2ANRequest.PostRequestBuilder = Rx2AndroidNetworking.post(Constants.LOGIN_URL)
        rxRequest.addHeaders(Constants.IMSI, "357175048449937")
        rxRequest.addHeaders(Constants.IMEI, "510110406068589")
        rxRequest.addApplicationJsonBody(request)
        return rxRequest.build().getObjectSingle(LoginResponse::class.java)
    }

}