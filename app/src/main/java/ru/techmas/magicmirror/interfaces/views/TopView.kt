package ru.techmas.magicmirror.interfaces.views

import ru.techmas.magicmirror.models.Photos


interface TopView : BaseView {
    fun showData(results: Photos)
}
