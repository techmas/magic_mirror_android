package ru.techmas.magicmirror.interfaces.views

import ru.techmas.magicmirror.models.AppData


interface ProfileView : BaseView {
    fun showMainActivity()
    fun showProfile(appData: AppData)
}
