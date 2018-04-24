package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.TopView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.models.Photos
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.PreferenceHelper

import javax.inject.Inject


@InjectViewState
class TopPresenter @Inject
constructor(val restApi: RestApi, val preferenceHelper: PreferenceHelper) : BasePresenter<TopView>() {
//        , BaseRecyclerAdapter.OnItemClickListener {

    init {
        getPhotos()
    }

    private fun getPhotos() {
        val request = restApi.photo.getPhotos(preferenceHelper.token!!, null, null, null)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successGetList(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

    private fun successGetList(response: ApiResponse<Photos>) {
        viewState.showData(response.data!!)
    }

}