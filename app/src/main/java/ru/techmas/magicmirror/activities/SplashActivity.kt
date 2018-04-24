package ru.techmas.magicmirror.activities

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.interfaces.views.SplashView
import ru.techmas.magicmirror.presenters.SplashPresenter
import ru.techmas.magicmirror.utils.Injector


class SplashActivity : BaseActivity(), SplashView {

    companion object {
        private val LAYOUT = R.layout.activity_splash
    }

    @InjectPresenter
    lateinit var splashPresenter: SplashPresenter

    @ProvidePresenter
    internal fun provideSplashPresenter(): SplashPresenter {
        return Injector.presenterComponent!!.splashPresenter
    }

    private var ltBackground: LinearLayout? = null
    private var btnRepeat: Button? = null
    private var tvSomethingWentWrong: TextView? = null
    private var progressBar: ProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(LAYOUT)
        super.onCreate(savedInstanceState)
        mvpDelegate.onAttach()


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


}
