package ru.techmas.magicmirror.presenters


import ru.techmas.magicmirror.interfaces.views.PhotoView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class PhotoPresenter @Inject
constructor() : BasePresenter<PhotoView>()