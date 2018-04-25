package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.AlbumView

import com.arellomobile.mvp.InjectViewState
import ru.noixlab.drivepoint.adapters.BaseRecyclerAdapter
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.models.Photos
import ru.techmas.magicmirror.utils.RxUtils
import ru.techmas.magicmirror.utils.presenter.PreferenceHelper

import javax.inject.Inject


@InjectViewState
class AlbumPresenter @Inject
constructor(val restApi: RestApi, val preferenceHelper: PreferenceHelper) : BasePresenter<AlbumView>(), BaseRecyclerAdapter.OnItemClickListener {

    override fun onClick(item: Any) {
    }

    init {
        getAlbum()
    }

    private fun getAlbum() {
        val request = restApi.album.getAlbum(preferenceHelper.token!!, null)
                .compose(RxUtils.httpSchedulers())
                .subscribe({ successGetList(it) }, { handleError(it) })
        unSubscribeOnDestroy(request)
    }

    private fun successGetList(response: ApiResponse<Photos>) {
        viewState.showData(response.data!!)
    }

}

