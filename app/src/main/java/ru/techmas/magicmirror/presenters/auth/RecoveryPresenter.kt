package ru.techmas.magicmirror.presenters.auth

import ru.techmas.magicmirror.interfaces.views.RecoveryView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.presenters.BasePresenter

import javax.inject.Inject


@InjectViewState
class RecoveryPresenter @Inject
constructor() : BasePresenter<RecoveryView>()
