package ru.techmas.magicmirror.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle

import ru.techmas.magicmirror.interfaces.views.SettingsView
import ru.techmas.magicmirror.presenters.SettingsPresenter
import ru.techmas.magicmirror.R

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import ru.techmas.magicmirror.utils.Injector


class SettingsActivity : BaseActivity(), SettingsView {

    override fun setupUI() {

    }

    override fun setupUX() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)
    }

    @InjectPresenter
    lateinit var settingsPresenter: SettingsPresenter

    @ProvidePresenter
    internal fun provideSettingsPresenter(): SettingsPresenter {
        return Injector.presenterComponent!!.settingsPresenter
    }

    companion object {

        private val LAYOUT = R.layout.activity_settings

        fun getIntent(context: Context): Intent {
            return Intent(context, SettingsActivity::class.java)
        }
    }
}
