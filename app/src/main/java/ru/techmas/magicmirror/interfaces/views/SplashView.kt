package ru.techmas.magicmirror.interfaces.views

import ru.techmas.magicmirror.interfaces.utils_view.NavigatorActivityView

interface SplashView : BaseView, NavigatorActivityView {
    fun showErrorConnection(show: Boolean)
}
