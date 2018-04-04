package ru.techmas.magicmirror.presenters

import android.util.Log
import ru.techmas.magicmirror.interfaces.views.LoginView

import com.arellomobile.mvp.InjectViewState
import retrofit2.Response
import ru.techmas.magicmirror.api.ApiResponse
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.TokenHelper

import javax.inject.Inject


@InjectViewState
class LoginPresenter @Inject
constructor(restApi: RestApi, tokenHelper: TokenHelper) : BasePresenter<LoginView>() {

    init {
        this.restApi = restApi
        this.tokenHelper= tokenHelper
    }

    fun loginUser(phone: String, password: String) {
        val request = restApi!!.user.login(phone, password)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successLogin(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

    private fun handleError(it: Throwable?) {
//        Log.d()
    }

    private fun successLogin(response: Response<ApiResponse<String>>) {
//        tokenHelper.token = response.token
    }
}
