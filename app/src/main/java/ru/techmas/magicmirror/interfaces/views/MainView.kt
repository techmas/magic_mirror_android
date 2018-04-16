package ru.techmas.magicmirror.interfaces.views

import com.arellomobile.mvp.MvpView
import ru.techmas.magicmirror.interfaces.utils_view.NavigatorActivityView

interface MainView : BaseView, NavigatorActivityView {
    fun closeDrawer()
}
