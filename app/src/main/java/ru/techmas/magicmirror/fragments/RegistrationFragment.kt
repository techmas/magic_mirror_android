package ru.techmas.magicmirror.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.techmas.magicmirror.interfaces.views.RegistrationView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.presenters.auth.RegistrationPresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_registration.*
import ru.techmas.magicmirror.utils.Injector


class RegistrationFragment : BaseFragment(), RegistrationView {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(LAYOUT, container, false)
        return rootView
    }

    override fun setupUI() {
        btnRegistration.setOnClickListener {
            registrationPresenter.registerUser(
                    etName.text.toString(),
                    etLastName.text.toString(),
                    etPhone.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString())
        }
        tvEntry.setOnClickListener { startFragment(LoginFragment.newInstance()) }

    }

    override fun setupUX() {

    }

    @InjectPresenter
    lateinit var registrationPresenter: RegistrationPresenter

    @ProvidePresenter
    internal fun provideRegistrationPresenter(): RegistrationPresenter {
        return Injector.presenterComponent!!.registrationPresenter
    }

    companion object {

        private val LAYOUT = R.layout.fragment_registration

        fun newInstance(): RegistrationFragment {
            val fragment = RegistrationFragment()

            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

}
