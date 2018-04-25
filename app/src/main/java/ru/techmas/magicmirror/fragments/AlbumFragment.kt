package ru.techmas.magicmirror.fragments

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.techmas.magicmirror.interfaces.views.AlbumView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.presenters.AlbumPresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_top.*
import ru.noixlab.drivepoint.adapters.AlbumAdapter
import ru.noixlab.drivepoint.adapters.TopAdapter
import ru.techmas.magicmirror.models.Photos
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

    override fun showData(results: Photos) {
        val adapter = AlbumAdapter(activity, results)
        adapter.onItemClickListener = albumPresenter
        recycler.layoutManager = GridLayoutManager(context, 3)
        recycler.adapter = adapter
    }

    @InjectPresenter
    lateinit var albumPresenter: AlbumPresenter

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
