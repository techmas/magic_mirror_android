package ru.techmas.magicmirror.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle

import ru.techmas.magicmirror.interfaces.views.PersonView
import ru.techmas.magicmirror.presenters.PersonPresenter
import ru.techmas.magicmirror.R


import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_person.*
import ru.techmas.magicmirror.api.models.PhotoDTO
import ru.techmas.magicmirror.utils.ImageLoader

import ru.techmas.magicmirror.utils.Injector
import ru.techmas.magicmirror.utils.loadImageFromUrl


class PersonActivity : BaseActivity(), PersonView {
    override fun setupUI() {

    }

    override fun setupUX() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)
    }

    @InjectPresenter
    lateinit var personPresenter: PersonPresenter

    override fun showPhoto(photo: PhotoDTO) {
        photo.detailPicture?.let { ivPhoto.loadImageFromUrl(it) }
        tvNumber.text = photo.photoRate.toString()
    }

    @ProvidePresenter
    internal fun providePersonPresenter(): PersonPresenter {
        return Injector.presenterComponent!!.personPresenter
    }

    companion object {

        private val LAYOUT = R.layout.activity_person

        fun getIntent(context: Context): Intent {
            return Intent(context, PersonActivity::class.java)
        }
    }
}
