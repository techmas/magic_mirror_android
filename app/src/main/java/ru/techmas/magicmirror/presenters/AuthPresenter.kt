package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.AuthView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class AuthPresenter @Inject
constructor() : BasePresenter<AuthView>() {
    init {
        viewState.showLoginFragment()
    }
}