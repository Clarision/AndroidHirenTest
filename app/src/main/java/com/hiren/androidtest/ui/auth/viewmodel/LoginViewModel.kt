package com.hiren.androidtest.ui.auth.viewmodel

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hiren.androidtest.R
import com.hiren.androidtest.database.entities.User
import com.hiren.androidtest.databinding.ActivityLoginBinding
import com.hiren.androidtest.network.AuthAuthApiClient
import com.hiren.androidtest.network.request.LoginRequest
import com.hiren.androidtest.ui.auth.activity.HomeActivity
import com.hiren.androidtest.utility.NetworkUtils
import com.jigar.kotlin.data.local.db.AppDbHelper
import com.jigar.kotlin.data.local.db.AppRoomDatabase
import com.jigar.kotlin.data.local.db.DbHelper
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel : ViewModel(), TextWatcher ,DbHelper{

    var userName: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> =  MutableLiveData()
    var binding: ActivityLoginBinding? = null
    var activity: FragmentActivity? = null
    val mCompositeDisposable: CompositeDisposable  = CompositeDisposable()

    init {
        userName.value = "username";
        password.value = "1111111"
    }
    @JvmName("setBinding1")
    fun setBinding(binding: ActivityLoginBinding) {
        this.binding = binding
        binding.watcher = this
    }

    @JvmName("setActivity1")
    fun setActivity(activity: FragmentActivity) {
        this.activity = activity
    }

    fun onLoginClick(view: View) {
        if(NetworkUtils.isNetworkConnected(activity!!)) {
            if (validation()) {
                binding?.progressBar?.visibility = View.VISIBLE
                val request = LoginRequest()
                request.setUserName(userName?.value!!)
                request.setPassword(password?.value!!)
                mCompositeDisposable.add(
                    AuthAuthApiClient().userLogin(request)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            {
                                if (it.getErrorCode() == "00") {
                                    binding?.progressBar?.visibility = View.GONE
                                    val mainIntent = Intent(activity, HomeActivity::class.java);
                                    mainIntent.putExtra("userName",it.getUserData().getUserName())
                                    activity?.startActivity(mainIntent)
                                }else{
                                    it.getMessage()
                                    binding?.progressBar?.visibility = View.GONE
                                }
                            },
                            {
                                binding?.progressBar?.visibility = View.GONE
                               Log.i("Login",it.message.toString())
                            }
                        )
                )
            }
        } else {
            Toast.makeText(activity!!, activity?.getString(R.string.error_internet), Toast.LENGTH_SHORT).show()
        }

    }

    fun validation(): Boolean {
        if (userName?.value.isNullOrEmpty()) {
            binding?.tilUserName?.isErrorEnabled = true
            binding?.tilUserName?.error = activity?.getString(R.string.error_username)
            return false
        }

        if (password?.value.isNullOrEmpty()) {
            binding?.tilPassword?.isErrorEnabled = true
            binding?.tilPassword?.error = activity?.getString(R.string.error_password)
            return false
        }
        return true
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (binding?.edtUsername?.hasFocus()!!) {
            binding?.tilUserName?.setErrorEnabled(false);
        } else if (binding?.edtPassword?.hasFocus()!!) {
            binding?.tilPassword?.setErrorEnabled(false);
        }
    }

    override fun afterTextChanged(s: Editable?) {}

    override fun saveUserDB(user: User) {
        this.saveUserDB(user)
    }

    override fun getLoggedUser(): Single<User> {
        return this.getLoggedUser()
    }
}