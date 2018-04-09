package ru.techmas.magicmirror.presenters.auth

import ru.techmas.magicmirror.interfaces.views.RegistrationView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.presenters.BasePresenter

import javax.inject.Inject


@InjectViewState
class RegistrationPresenter @Inject
constructor() : BasePresenter<RegistrationView>()
