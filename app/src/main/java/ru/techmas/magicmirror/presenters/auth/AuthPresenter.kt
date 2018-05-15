package ru.techmas.magicmirror.presenters.auth

import ru.techmas.magicmirror.interfaces.views.AuthView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.presenters.BasePresenter

import javax.inject.Inject


@InjectViewState
class AuthPresenter @Inject
constructor() : BasePresenter<AuthView>() {
    init {
        viewState.showLoginFragment()
//        viewState.showRegistrationFragment()
    }
}