package ru.techmas.magicmirror.presenters

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.Const
import ru.techmas.magicmirror.activities.AuthActivity

import javax.inject.Inject

import ru.techmas.magicmirror.activities.MainActivity
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.models.UserDTO
import ru.techmas.magicmirror.interfaces.views.SplashView
import ru.techmas.magicmirror.models.AppData
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.TokenHelper


@InjectViewState
class SplashPresenter @Inject
internal constructor(restApi: RestApi, preferenceHelper: TokenHelper, val appData: AppData) : BasePresenter<SplashView>() {

    init {
        this.restApi = restApi
        this.tokenHelper = preferenceHelper
        startNext()
    }


    fun startNext() {
        viewState.showErrorConnection(false)
        if (tokenHelper!!.isFirstRun)
            viewState.startActivity(AuthActivity::class.java)
        else
            getProfile()
    }

    private fun getProfile() {
        val request = restApi!!.user.getProfile(tokenHelper!!.token!!)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successGetProfile(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)


    }

    override fun handleError(it: Throwable?) {
        super.handleError(it)
        viewState.startActivity(AuthActivity::class.java)
    }

    private fun successGetProfile(response: ApiResponse<UserDTO>) {
        if (response.status != Const.API.STATUS_ERROR) {
            appData.user = response.data!!
            viewState.startActivity(MainActivity::class.java)
        }
    }
}
