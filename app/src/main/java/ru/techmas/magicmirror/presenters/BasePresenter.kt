package ru.techmas.magicmirror.presenters

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

import org.greenrobot.eventbus.EventBus

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.utils.presenter.TokenHelper


/**
 * Created by Alex Bykov on 15.02.2017.
 * You can contact me at: me@alexbykov.ru.
 */

open class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    open var restApi: RestApi? = null
    open var tokenHelper: TokenHelper? = null
    //
    open val TAG = javaClass.simpleName



    private val compositeDisposable = CompositeDisposable()


    protected fun unSubscribeOnDestroy(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
