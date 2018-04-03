package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.LoginView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class LoginPresenter @Inject
constructor() : BasePresenter<LoginView>()
