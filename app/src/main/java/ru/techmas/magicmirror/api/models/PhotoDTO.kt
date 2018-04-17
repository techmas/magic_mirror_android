package ru.techmas.magicmirror.api.models

import com.google.gson.annotations.SerializedName
import java.net.URL

/*
 {
                "ID": "417",
                "NAME": "[\n  "title"\n]",
                "DETAIL_PICTURE": "http://magicmirror-v2.techmas.ru:80/upload/iblock/799/image.jpg",
                "PREVIEW_PICTURE": "http://magicmirror-v2.techmas.ru:80/upload/iblock/9b7/image.jpg",
                "PROPERTY_PHOTO_RATE_VALUE": "1039",
                "PROPERTY_PHOTO_USER_VALUE": "47",
                "DETAIL_TEXT_TYPE": "text",
                "USER_RATE_ID": "47"
            }
 */
data class PhotoDTO (
        @SerializedName("ID")
        var id: Long? = null,

        @SerializedName("NAME")
        var name: String? = null,

        @SerializedName("DETAIL_PICTURE")
        var detailPicture: String? = null,

        @SerializedName("PREVIEW_PICTURE")
        var previewPicture: String? = null,

        @SerializedName("PROPERTY_PHOTO_RATE_VALUE")
        var propertyPhotoRateValue: Int? = null,

        @SerializedName("PROPERTY_PHOTO_USER_VALUE")
        var propertyPhotoUserValue: Int? = null,

        @SerializedName("DETAIL_TEXT_TYPE")
        var detailTextType: String? = null,

        @SerializedName("USER_RATE_ID")
        var userRateID: Int? = null
        )