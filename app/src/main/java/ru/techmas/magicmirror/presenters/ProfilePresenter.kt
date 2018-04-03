package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.ProfileView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class ProfilePresenter @Inject
constructor() : BasePresenter<ProfileView>()
