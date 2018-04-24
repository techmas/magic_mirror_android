package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.TopView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.models.Photos
import ru.techmas.magicmirror.utils.RxUtils

import javax.inject.Inject


@InjectViewState
class TopPresenter @Inject
constructor(val restApi: RestApi, val preferenceHelper: PreferenceHelper) : BasePresenter<TopView>(), BaseRecyclerAdapter.OnItemClickListener {

    init {
        getToken()
    }

    private fun getToken() {
        val request = restApi.auth.geToken("android", "No!xlab2018")
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successGetToken(it)}, {handleError(it)})
        unSubscribeOnDestroy(request)
    }

    private fun successGetToken(response: TokenResponse) {
        preferenceHelper.token = response.key
        getPhoto()
    }


private fun getPhoto() {
    val request = restApi.photo.getVPhoto()
            .compose(RxUtils.httpSchedulers())
            .subscribe({ successGetList(it)}, { handleError(it) })
    unSubscribeOnDestroy(request)
}

private fun successGetList(response: ListResponse<Photos>) {
    viewState.showData(response.results)
}
