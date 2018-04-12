package ru.techmas.magicmirror.presenters

import android.support.design.widget.NavigationView
import android.util.Log
import android.view.MenuItem
import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.interfaces.views.MainView
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter @Inject
internal constructor(restApi: RestApi) : BasePresenter<MainView>(), NavigationView.OnNavigationItemSelectedListener {

    init {
        this.restApi = restApi
        Log.d(TAG, "MainActivityPresenter: text")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }

}
