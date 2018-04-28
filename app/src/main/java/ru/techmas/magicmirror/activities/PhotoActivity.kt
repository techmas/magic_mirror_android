package ru.techmas.magicmirror.activities

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle

import ru.techmas.magicmirror.interfaces.views.PhotoView
import ru.techmas.magicmirror.presenters.PhotoPresenter
import ru.techmas.magicmirror.R


import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_photo.*
import ru.techmas.magicmirror.utils.CameraHelper

import ru.techmas.magicmirror.utils.Injector

class PhotoActivity : BaseActivity(), PhotoView {

    lateinit var cameraHelper: CameraHelper

    override fun showPhoto(bitmap: Bitmap) {
        ivPhoto.setImageBitmap(bitmap)
    }

    override fun setupUI() {
        takePhoto()
    }

    override fun setupUX() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(LAYOUT)
        super.onCreate(savedInstanceState)

//        ivPhotoSel.setOnClickListener {
//        }
    }

    private fun takePhoto() {
        cameraHelper = CameraHelper(this)
                .setFilePrefix("Magic")
                .setViewDimensions(ivPhoto)
                .onSuccess(photoPresenter)
                .onError(photoPresenter)
                .execute()
    }

//    override fun showPhoto(bitmap: Bitmap) {
//        ivPhoto.setImageBitmap(bitmap)
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        cameraHelper.onActivityResult(requestCode, resultCode, data)
    }


    @InjectPresenter
    lateinit var photoPresenter: PhotoPresenter

    @ProvidePresenter
    internal fun providePhotoPresenter(): PhotoPresenter {
        return Injector.presenterComponent!!.photoPresenter
    }

    companion object {

        private val LAYOUT = R.layout.activity_photo

        fun getIntent(context: Context): Intent {
            return Intent(context, PhotoActivity::class.java)
        }
    }
}
