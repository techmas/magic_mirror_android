package ru.techmas.magicmirror.presenters

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.activities.AuthActivity

import javax.inject.Inject

import ru.techmas.magicmirror.activities.MainActivity
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.interfaces.views.SplashView
import ru.techmas.magicmirror.utils.presenter.TokenHelper


@InjectViewState
class SplashPresenter @Inject
internal constructor(restApi: RestApi, preferenceHelper: TokenHelper) : BasePresenter<SplashView>() {

    init {
        this.restApi = restApi
        this.tokenHelper = preferenceHelper
        startNext()
    }


    fun startNext() {
//        viewState.showErrorConnection(false)
//        if (tokenHelper!!.isFirstRun)
            viewState.startActivity(AuthActivity::class.java)
//        else
//            viewState.startActivity(MainActivity::class.java)
    }

}
