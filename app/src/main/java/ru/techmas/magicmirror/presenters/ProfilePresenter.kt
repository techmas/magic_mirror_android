package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.ProfileView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.Const
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.models.HashResponse
import ru.techmas.magicmirror.api.models.PhotoDTO
import ru.techmas.magicmirror.models.AppData
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.PreferenceHelper

import javax.inject.Inject


@InjectViewState
class ProfilePresenter @Inject
constructor(val restApi: RestApi, val preferenceHelper: PreferenceHelper, val appData: AppData) : BasePresenter<ProfileView>() {

    init {
        getProfile()
    }

    private fun getProfile() {
        val request = restApi.user.getPhoto(preferenceHelper.token!!, appData.user.token!!)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successGetProfile(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

    private fun successGetProfile(response: ApiResponse<HashResponse<PhotoDTO>>) {
        if (response.status != Const.API.STATUS_ERROR) {
            appData.photo = response.data!!["best_photo"]!![0]
            viewState.showProfile(appData)
        }
    }
}


