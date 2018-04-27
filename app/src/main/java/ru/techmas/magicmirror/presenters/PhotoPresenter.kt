package ru.techmas.magicmirror.presenters


import android.graphics.Bitmap
import ru.techmas.magicmirror.interfaces.views.PhotoView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.utils.CameraHelper

import javax.inject.Inject


@InjectViewState
class PhotoPresenter @Inject
constructor() : BasePresenter<PhotoView>(), CameraHelper.OnSuccessListener, CameraHelper.OnErrorListener {

    override fun errorCamera(message: String) {
    }

    override fun successCameraPhoto(name: String, bitmap: Bitmap) {
        viewState.showPhoto(bitmap)
    }
}