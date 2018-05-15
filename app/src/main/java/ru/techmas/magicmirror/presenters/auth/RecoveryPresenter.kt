package ru.techmas.magicmirror.presenters.auth

import ru.techmas.magicmirror.interfaces.views.RecoveryView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.Const
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.presenters.BasePresenter
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.Resources

import javax.inject.Inject


@InjectViewState
class RecoveryPresenter @Inject
constructor(val restApi: RestApi, val resources: Resources) : BasePresenter<RecoveryView>() {

    fun sendRecoverRequest(phone: String, email: String) {
        if (phone.isEmpty() && email.isEmpty())
            viewState.showError(resources.getString(R.string.phone_email_empty))
        val data = if (phone.isEmpty()) email else phone
        val request = restApi.user.sendRecovery(data)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successSendRecovery(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

    private fun successSendRecovery(response: ApiResponse<String>) {
        if (response.status != Const.API.STATUS_ERROR) {
            viewState.showRecoveryControl()
        }
    }

    fun checkCode(code: String, password: String, confirm: String) {
        if (password == confirm) {
            val request = restApi.user.checkRecovery(code, password, confirm)
                    .compose(RxUtils.httpSchedulers())
                    .subscribe({ successCheckRecovery(it) }, { handleError(it) })
            unSubscribeOnDestroy(request)
        } else {
            viewState.showError(resources.getString(R.string.passwords_not_match))
        }
    }

    private fun successCheckRecovery(response: ApiResponse<String>) {
        if (response.status != Const.API.STATUS_ERROR) {
            viewState.showRecoverySuccess()
        }
    }
}
