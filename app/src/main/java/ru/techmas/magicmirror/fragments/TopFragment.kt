package ru.techmas.magicmirror.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.techmas.magicmirror.interfaces.views.TopView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.presenters.TopPresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_top.*
import ru.noixlab.drivepoint.adapters.TopAdapter
import ru.techmas.magicmirror.models.Photos
import ru.techmas.magicmirror.utils.Injector


class TopFragment : BaseFragment(), TopView {

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
        val adapter = TopAdapter(activity, results)
        adapter.onItemClickListener = topPresenter
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
    }

    @InjectPresenter
    lateinit var topPresenter: TopPresenter

    @ProvidePresenter
    internal fun provideTopPresenter(): TopPresenter {
        return Injector.presenterComponent!!.topPresenter
    }

    companion object {

        private val LAYOUT = R.layout.fragment_top

        fun newInstance(): TopFragment {
            val fragment = TopFragment()

            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

}
