package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.TopView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class TopPresenter @Inject
constructor() : BasePresenter<TopView>()
