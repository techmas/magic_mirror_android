package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.RegistrationView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class RegistrationPresenter @Inject
constructor() : BasePresenter<RegistrationView>()
