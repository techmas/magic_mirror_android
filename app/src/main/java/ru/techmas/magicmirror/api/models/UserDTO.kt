package ru.techmas.magicmirror.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDTO(
        @SerializedName("ID")
        var id: Long? = null,

        @SerializedName("TIMESTAMP_X")
        var timestamp: String? = null,

        @SerializedName("LOGIN")
        var login: String? = null,

        @SerializedName("PASSWORD")
        var password: String? = null,

        @SerializedName("CHECKWORD")
        var checkword: String? = null,

        @SerializedName("ACTIVE")
        var active: String? = null,

        @SerializedName("NAME")
        var name: String? = null,

        @SerializedName("LAST_NAME")
        var lastName: String? = null,

        @SerializedName("EMAIL")
        var email: String? = null,

        @SerializedName("LAST_LOGIN")
        var lastLogin: String? = null,

        @SerializedName("DATE_REGISTER")
        var dateRegister: String? = null,

        @SerializedName("LID")
        var lid: String? = null,

        @SerializedName("PERSONAL_BIRTHDAY")
        var userBirhday: String? = null,

        @SerializedName("CHECKWORD_TIME")
        var checkWordTime: String? = null,

        @SerializedName("IS_ONLINE")
        var isOnline: String? = null,

        @SerializedName("TOKEN")
        var token: String? = null,

        @SerializedName("UF_IS_RATE")
        var ufIsRate: String? = null,

        @SerializedName("PERSONAL_MOBILE")
        var personalMobile: String? = null


//        @SerializedName("USER_GROUP")
//        var userGroup: String? = null
)