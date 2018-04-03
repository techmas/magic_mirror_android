package ru.techmas.magicmirror.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.techmas.magicmirror.interfaces.views.AlbumView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.presenters.AlbumPresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.techmas.magicmirror.utils.Injector


class AlbumFragment : BaseFragment(), AlbumView {

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
    internal var albumPresenter: AlbumPresenter? = null

    @ProvidePresenter
    internal fun provideAlbumPresenter(): AlbumPresenter {
        return Injector.presenterComponent!!.albumPresenter
    }

    companion object {

        private val LAYOUT = R.layout.fragment_album

        fun newInstance(): AlbumFragment {
            val fragment = AlbumFragment()

            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

}
