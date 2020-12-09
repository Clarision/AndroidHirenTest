package com.hiren.androidtest.ui.auth.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.hiren.androidtest.databinding.ActivityHomeBinding
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel : ViewModel() {

    var binding: ActivityHomeBinding? = null
    var activity: FragmentActivity? = null
    val mCompositeDisposable: CompositeDisposable  = CompositeDisposable()

    init {
       /* mCompositeDisposable.add(
            getLoggedUser()
            .subscribeOn(Schedulers.io())
            .subscribe({ data ->
                binding?.tvUserName?.text = data.getUserName()
            }, { throwable ->
                Log.e("Error", throwable.message.toString())
            })
        )*/
    }
    @JvmName("setBinding1")
    fun setBinding(binding: ActivityHomeBinding) {
        this.binding = binding
    }

    @JvmName("setActivity1")
    fun setActivity(activity: FragmentActivity) {
        this.activity = activity
    }

    fun setUserName(userName: String) {
        binding?.tvUserName?.text = userName
    }
}