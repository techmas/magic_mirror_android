package ru.techmas.magicmirror.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.techmas.magicmirror.interfaces.views.RecoveryView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.presenters.RecoveryPresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.techmas.magicmirror.utils.Injector


class RecoveryFragment : BaseFragment(), RecoveryView {

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
    lateinit var recoveryPresenter: RecoveryPresenter

    @ProvidePresenter
    internal fun provideRecoveryPresenter(): RecoveryPresenter {
        return Injector.presenterComponent!!.recoveryPresenter
    }

    companion object {

        private val LAYOUT = R.layout.fragment_recovery

        fun newInstance(): RecoveryFragment {
            val fragment = RecoveryFragment()

            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

}
