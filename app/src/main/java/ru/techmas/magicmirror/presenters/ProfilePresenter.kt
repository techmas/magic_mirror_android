package ru.techmas.magicmirror.presenters

import ru.techmas.magicmirror.interfaces.views.ProfileView

import com.arellomobile.mvp.InjectViewState
import ru.techmas.magicmirror.Const
import ru.techmas.magicmirror.api.RestApi
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.models.BestPhoto

import javax.inject.Inject


@InjectViewState
class ProfilePresenter @Inject
constructor(restApi: RestApi, val bestPhoto: BestPhoto) : BasePresenter<ProfileView>() {

    init {
        this.restApi = restApi
        this.tokenHelper= tokenHelper
    }

    private fun profileResponse(response: ApiResponse<BestPhoto>) {
        if (response.status != Const.API.STATUS_ERROR) {
            bestPhoto.name = response.data!!.name
            bestPhoto.propertyPhotoRateValue = response.data!!.propertyPhotoRateValue
            bestPhoto.propertyPhotoUserValue = response.data!!.propertyPhotoUserValue
            bestPhoto.previewPicture = response.data!!.previewPicture

            viewState.showMainActivity()
        }
    }


}


