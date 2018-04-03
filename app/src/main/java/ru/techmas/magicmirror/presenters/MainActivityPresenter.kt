package ru.techmas.magicmirror.presenters

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.interfaces.views.MainView
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter @Inject
internal constructor(restApi: RestApi) : BasePresenter<MainView>() {


    init {
        this.restApi = restApi
        Log.d(TAG, "MainActivityPresenter: text")
    }

}
