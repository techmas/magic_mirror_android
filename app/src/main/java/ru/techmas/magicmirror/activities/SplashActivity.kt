package ru.techmas.magicmirror.activities

import android.Manifest
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.alexbykov.nopermission.PermissionHelper

import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.interfaces.views.SplashView
import ru.techmas.magicmirror.presenters.SplashPresenter
import ru.techmas.magicmirror.utils.Injector


class SplashActivity : BaseActivity(), SplashView {

    private lateinit var permissionHelper: PermissionHelper

    private var ltBackground: LinearLayout? = null
    private var btnRepeat: Button? = null
    private var tvSomethingWentWrong: TextView? = null
    private var progressBar: ProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(LAYOUT)
        super.onCreate(savedInstanceState)
        mvpDelegate.onAttach()
        checkPermissions()
    }

    private fun checkPermissions() {
        permissionHelper = PermissionHelper(this)
        permissionHelper.check(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .onSuccess(Runnable { this.successPermission() })
                .onFailure(Runnable { this.failurePermission() })
                .run()
    }

    private fun failurePermission() {
        checkPermissions()
    }

    private fun successPermission() {
        splashPresenter.startNext()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        permissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun setupUX() {
        btnRepeat!!.setOnClickListener { splashPresenter.startNext() }
    }

    override fun showErrorConnection(show: Boolean) {
        if (show) {
            hideView(progressBar!!)
            showView(ltBackground!!)

            animationHelper.scaleIn(tvSomethingWentWrong!!)
        } else
            hideView(ltBackground!!)
    }

    override fun setupUI() {
        ltBackground = bindView<LinearLayout>(R.id.ltBackground)
        btnRepeat = bindView<Button>(R.id.btnRepeat)
        tvSomethingWentWrong = bindView<TextView>(R.id.tvSomethingWentWrong)
        progressBar = bindView<ProgressBar>(R.id.progressBar)
    }


    @InjectPresenter
    lateinit var splashPresenter: SplashPresenter

    @ProvidePresenter
    internal fun provideSplashPresenter(): SplashPresenter {
        return Injector.presenterComponent!!.splashPresenter
    }

    companion object {
        private val LAYOUT = R.layout.activity_splash
    }


}
