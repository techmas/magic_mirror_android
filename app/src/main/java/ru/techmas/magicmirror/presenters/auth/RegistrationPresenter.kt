package ru.techmas.magicmirror.presenters.auth

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.Const
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.models.UserDTO
import ru.techmas.magicmirror.interfaces.views.LoginView
import ru.techmas.magicmirror.interfaces.views.RegistrationView
import ru.techmas.magicmirror.models.AppData
import ru.techmas.magicmirror.presenters.BasePresenter
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.PreferenceHelper

import javax.inject.Inject


@InjectViewState
class RegistrationPresenter @Inject
constructor(val restApi: RestApi, val preferenceHelper: PreferenceHelper, val appData: AppData) : BasePresenter<RegistrationView>() {

    init {
    }

    fun registerUser(name: String, lastName: String, phone: String, email: String, password: String) {
        val request = restApi.user.registration(phone, password, email, name, lastName)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successRegistration(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

    private fun successRegistration(response: ApiResponse<String>) {
//        viewState.close()
        if (response.status != Const.API.STATUS_ERROR) {
//            preferenceHelper.token = response.data!!.token
//            appData.user = response.data!!
//            viewState.showMainActivity()
        }
    }

    private fun successLogin(response: ApiResponse<UserDTO>) {
    }
}