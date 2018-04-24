package ru.techmas.magicmirror.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle

import ru.techmas.magicmirror.interfaces.views.SettingsView
import ru.techmas.magicmirror.presenters.SettingsPresenter
import ru.techmas.magicmirror.R

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_settings.*
import ru.techmas.magicmirror.api.models.UserDTO

import ru.techmas.magicmirror.utils.Injector


class SettingsActivity : BaseActivity(), SettingsView {

    override fun setupUI() {

    }

    override fun setupUX() {
        //         btnEntry.setOnClickListener { loginPresenter.loginUser(etPhone.text.toString(), etPassword.text.toString())}
        btnSave.setOnClickListener {
            settingsPresenter.saveProfile(
                    etName.text.toString(),
                    etSurname.text.toString())
        }
    }

    override fun showUserData(user: UserDTO) {
        // Сюда сбиндить со лэйаута все поля!!
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
