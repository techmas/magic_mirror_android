package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.AlbumView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class AlbumPresenter @Inject
internal constructor() : BasePresenter<AlbumView>()

