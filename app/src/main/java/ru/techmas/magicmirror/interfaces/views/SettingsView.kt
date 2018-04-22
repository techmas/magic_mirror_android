package ru.techmas.magicmirror.interfaces.views

import ru.techmas.magicmirror.api.models.UserDTO


interface SettingsView : BaseView {
    fun showUserData(user: UserDTO)
}
