package ru.techmas.magicmirror.interfaces.views

import ru.techmas.magicmirror.interfaces.utils_view.BaseLifeCycle


interface RecoveryView : BaseView, BaseLifeCycle {
    fun showRecoveryControl()
    fun showRecoverySuccess()
}
