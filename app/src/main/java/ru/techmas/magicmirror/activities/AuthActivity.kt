package ru.techmas.magicmirror.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle

import ru.techmas.magicmirror.interfaces.views.AuthView
import ru.techmas.magicmirror.presenters.auth.AuthPresenter
import ru.techmas.magicmirror.R

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.techmas.magicmirror.fragments.LoginFragment

import ru.techmas.magicmirror.utils.Injector
import ru.techmas.magicmirror.utils.Navigator


class AuthActivity : BaseActivity(), AuthView {

    override fun setupUI() {

    }

    override fun setupUX() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)
    }

    override fun showLoginFragment() {
        Navigator.startFragment(LoginFragment.newInstance(), supportFragmentManager, R.id.ltContainer)
    }

    @InjectPresenter
    lateinit var authPresenter: AuthPresenter

    @ProvidePresenter
    internal fun provideAuthPresenter(): AuthPresenter {
        return Injector.presenterComponent!!.authActivityPresenter
    }

    companion object {

        private val LAYOUT = R.layout.activity_auth

        fun getIntent(context: Context): Intent {
            return Intent(context, AuthActivity::class.java)
        }
    }
}
