package ru.techmas.magicmirror.presenters.auth

import ru.techmas.magicmirror.interfaces.views.LoginView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.Const
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.models.UserDTO
import ru.techmas.magicmirror.models.AppData
import ru.techmas.magicmirror.presenters.BasePresenter
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.TokenHelper

import javax.inject.Inject


@InjectViewState
class LoginPresenter @Inject
constructor(restApi: RestApi, tokenHelper: TokenHelper, val appData: AppData) : BasePresenter<LoginView>() {

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

    private fun successLogin(response: ApiResponse<UserDTO>) {
        if (response.status != Const.API.STATUS_ERROR) {
            tokenHelper!!.token = response.data!!.token
            appData.user = response.data!!
            viewState.showMainActivity()
        }
    }
}
