package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.SettingsView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class SettingsPresenter @Inject
constructor() : BasePresenter<SettingsView>()