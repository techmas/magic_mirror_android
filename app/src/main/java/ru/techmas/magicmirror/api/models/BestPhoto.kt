package ru.techmas.magicmirror.api.models

import com.google.gson.annotations.SerializedName
import java.net.URL

data class BestPhoto (
        @SerializedName("ID")
        var id: Long? = null,

        @SerializedName("NAME")
        var name: String? = null,

        @SerializedName("DETAIL_PICTURE")
        var detailPicture: URL? = null,

        @SerializedName("PREVIEW_PICTURE")
        var previewPicture: URL? = null,

        @SerializedName("PROPERTY_PHOTO_RATE_VALUE")
        var propertyPhotoRateValue: Long? = null,

        @SerializedName("PROPERTY_PHOTO_USER_VALUE")
        var propertyPhotoUserValue: Long? = null,

        @SerializedName("DETAIL_TEXT_TYPE")
        var detailTextType: String? = null,

        @SerializedName("USER_RATE_ID")
        var userRateID: Long? = null
        )