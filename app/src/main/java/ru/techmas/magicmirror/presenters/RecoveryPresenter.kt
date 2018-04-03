package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.RecoveryView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class RecoveryPresenter @Inject
constructor() : BasePresenter<RecoveryView>()
