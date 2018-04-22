package ru.techmas.magicmirror.presenters

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.Const
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.endpoints.User
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.models.UserDTO
import ru.techmas.magicmirror.interfaces.views.ProfileView
import ru.techmas.magicmirror.models.AppData
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.TokenHelper
import javax.inject.Inject

@InjectViewState
class ChangeProfilePresenter @Inject
constructor(restApi: RestApi, tokenHelper: TokenHelper, val appData: AppData) : BasePresenter<ProfileView>() {

    init {
        this.restApi = restApi
        this.tokenHelper = tokenHelper
        getProfile()
    }

    private fun getProfile() {
        val request = restApi!!.user.getPhoto(tokenHelper!!.token!!, appData.user.token!!)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successGetProfile(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

     fun successGetProfile(response: ApiResponse<UserDTO>) {
        if (response.status != Const.API.STATUS_ERROR) {
            appData.user.login = response.data!!.login
            viewState.showProfile(appData)
        }
    }

    fun updateProfile(userDTO: UserDTO) {
        val request = restApi!!.user.updateProfile(UserDTO())
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successUpdate(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

     fun successUpdate(response: ApiResponse<UserDTO>) {
        if (response.status != Const.API.STATUS_ERROR) {
            tokenHelper!!.token = response.data!!.token
            appData.user = response.data!!

        }
    }


}
