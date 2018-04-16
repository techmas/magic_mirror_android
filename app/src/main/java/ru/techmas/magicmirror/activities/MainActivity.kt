package ru.techmas.magicmirror.activities


import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.interfaces.utils_view.NavigatorActivityView
import ru.techmas.magicmirror.interfaces.views.MainView
import ru.techmas.magicmirror.presenters.MainActivityPresenter
import ru.techmas.magicmirror.utils.Injector

class MainActivity : BaseActivity(), MainView, NavigatorActivityView{

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(LAYOUT)
        super.onCreate(savedInstanceState)
    }

    override fun closeDrawer() {
        drawer.closeDrawers()
    }

    override fun setupUI() {
        setSupportActionBar(toolbar)
//        supportActionBar!!.title="TEST"
    }

    override fun setupUX() {
        setUpDrawerMenu()
    }

    private fun setUpDrawerMenu() {
        supportActionBar!!.setHomeButtonEnabled(true)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        toggle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(mainPresenter)
    }

    @InjectPresenter
    lateinit var mainPresenter: MainActivityPresenter

    @ProvidePresenter
    internal fun provideMainActivityPresenter(): MainActivityPresenter {
        return Injector.presenterComponent!!.mainActivityPresenter
    }

    companion object {
        private val LAYOUT = R.layout.activity_main
    }
}
