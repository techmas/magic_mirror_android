package ru.techmas.magicmirror.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import ru.techmas.magicmirror.interfaces.views.ProfileView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.presenters.ProfilePresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_profile.*
import ru.techmas.magicmirror.activities.MainActivity
import ru.techmas.magicmirror.utils.Injector


class ProfileFragment : BaseFragment(), ProfileView {
    override fun setupUI() {

    }

    override fun setupUX() {

        ivPhoto?.loadImageFromUrl(profilePresenter.bestPhoto.previewPicture as String)
        tvNumber?.text = profilePresenter.bestPhoto.propertyPhotoRateValue as String
        tvName?.text = profilePresenter.bestPhoto.name as String
        tvRating?.text = profilePresenter.bestPhoto.propertyPhotoUserValue as String
    }

    override fun showMainActivity() {
        startActivity(MainActivity::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(LAYOUT, container, false)
        return rootView
    }

    @InjectPresenter
    lateinit var profilePresenter: ProfilePresenter

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


    fun ImageView.loadImageFromUrl(url: String) {
        Glide.with(context)
                .load(url)
                .into(this)
    }
}
