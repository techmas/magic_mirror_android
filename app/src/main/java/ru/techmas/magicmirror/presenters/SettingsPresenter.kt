package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.SettingsView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.Const
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.models.UserDTO
import ru.techmas.magicmirror.models.AppData
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.PreferenceHelper

import javax.inject.Inject


@InjectViewState
class SettingsPresenter @Inject
constructor(val restApi: RestApi, val preferenceHelper: PreferenceHelper, val appData: AppData) : BasePresenter<SettingsView>() {


    init {
        getProfile()
    }

    private fun getProfile() {
        val request = restApi.user.getProfile(preferenceHelper.token!!)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successGetProfile(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

    fun successGetProfile(response: ApiResponse<UserDTO>) {
        if (response.status != Const.API.STATUS_ERROR) {
            appData.user = response.data!!
            viewState.showUserData(appData.user)
        }
    }

    fun updateProfile() {
        val request = restApi!!.user.updateProfile(appData.user)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successUpdate(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

    fun successUpdate(response: ApiResponse<UserDTO>) {
        if (response.status != Const.API.STATUS_ERROR) {
            preferenceHelper.token = response.data!!.token
            appData.user = response.data!!
        }
    }

    fun saveProfile(name: String, surName: String) {
        appData.user.name = name
        appData.user.lastName = surName
        updateProfile()
    }
}