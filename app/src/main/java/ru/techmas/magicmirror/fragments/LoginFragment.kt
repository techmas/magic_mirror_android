package ru.techmas.magicmirror.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.techmas.magicmirror.interfaces.views.LoginView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.presenters.LoginPresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_login.*
import ru.techmas.magicmirror.utils.Injector


class LoginFragment : BaseFragment(), LoginView {
    override fun setupUI() {

    }

    override fun setupUX() {
        btnEntry.setOnClickListener { loginPresenter.loginUser(etPhone.text.toString(), etPassword.text.toString())}
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(LAYOUT, container, false)
        return rootView
    }

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    @ProvidePresenter
    internal fun provideLoginPresenter(): LoginPresenter {
        return Injector.presenterComponent!!.loginPresenter
    }

    companion object {

        private val LAYOUT = R.layout.fragment_login

        fun newInstance(): LoginFragment {
            val fragment = LoginFragment()

            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

}
