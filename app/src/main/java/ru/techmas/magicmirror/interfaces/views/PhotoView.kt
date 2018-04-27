package ru.techmas.magicmirror.interfaces.views

import android.graphics.Bitmap


interface PhotoView : BaseView {
    fun showPhoto(bitmap: Bitmap)
}
