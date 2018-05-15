package ru.techmas.magicmirror.interfaces.views

import android.content.Context
import android.support.v7.widget.RecyclerView
import ru.techmas.magicmirror.interfaces.utils_view.NavigatorActivityView
import ru.techmas.magicmirror.models.Photos

interface AlbumView : BaseView, NavigatorActivityView {
    fun showData(results: Photos)
}

