package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.PersonView

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject


@InjectViewState
class PersonPresenter @Inject
constructor() : BasePresenter<PersonView>()