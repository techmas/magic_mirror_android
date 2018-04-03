package ru.techmas.magicmirror.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.techmas.magicmirror.interfaces.views.ProfileView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.presenters.ProfilePresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.techmas.magicmirror.utils.Injector


class ProfileFragment : BaseFragment(), ProfileView {
    override fun setupUI() {

    }

    override fun setupUX() {

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(LAYOUT, container, false)
        return rootView
    }

    @InjectPresenter
    internal var profilePresenter: ProfilePresenter? = null

    @ProvidePresenter
    internal fun provideProfilePresenter(): ProfilePresenter {
        return Injector.presenterComponent!!.profilePresenter
    }

    companion object {

        private val LAYOUT = R.layout.fragment_profile

        fun newInstance(): ProfileFragment {
            val fragment = ProfileFragment()

            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

}
