package ru.techmas.magicmirror.di.components

import javax.inject.Singleton

import dagger.Component
import ru.techmas.magicmirror.App
import ru.techmas.magicmirror.di.modules.RestModule
import ru.techmas.magicmirror.di.modules.UtilsModule
import ru.techmas.magicmirror.presenters.*

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */


@Singleton
@Component(modules = arrayOf(RestModule::class, UtilsModule::class))
interface PresenterComponent {
    //@formatter:off
    fun inject(app: App)

    val mainActivityPresenter: MainActivityPresenter
    val splashPresenter: SplashPresenter
    val authActivityPresenter: AuthPresenter
    val registrationPresenter: RegistrationPresenter
    val loginPresenter: LoginPresenter
    val recoveryPresenter: RecoveryPresenter
    val settingsPresenter: SettingsPresenter
    val albumPresenter: AlbumPresenter
    val profilePresenter: ProfilePresenter
    val topPresenter: TopPresenter
    val personPresenter: PersonPresenter
}
