package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.PersonView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.models.AppData

import javax.inject.Inject


@InjectViewState
class PersonPresenter @Inject
constructor(val appData: AppData) : BasePresenter<PersonView>() {
    init {
        viewState.showPhoto(appData.photo)
    }
}