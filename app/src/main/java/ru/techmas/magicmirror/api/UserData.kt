package ru.techmas.magicmirror.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserData
(
            @Expose
            @SerializedName("ID")
            var id: Long? = null,

            @Expose
            @SerializedName("TIMESTAMP_X")
            var timestamp_X: String? = null,

            @Expose
            @SerializedName("LOGIN")
            var login: String? = null,

            @Expose
            @SerializedName("PASSWORD")
            var password: String? = null,

            @Expose
            @SerializedName("CHECKWORD")
            var checkword: String? = null,

            @Expose
            @SerializedName("ACTIVE")
            var active: String? = null,

            @Expose
            @SerializedName("NAME")
            var name: String? = null,

            @Expose
            @SerializedName("LAST_NAME")
            var lastName: String? = null,

            @Expose
            @SerializedName("EMAIL")
            var email: String? = null,

            @Expose
            @SerializedName("LAST_LOGIN")
            var lastLogin: String? = null,

            @Expose
            @SerializedName("DATE_REGISTER")
            var dateRegister: String? = null,

            @Expose
            @SerializedName("LID")
            var lid: String? = null,

            @Expose
            @SerializedName("PERSONAL_BIRTHDAY")
            var userBirhday: String? = null,

            @Expose
            @SerializedName("CHECKWORD_TIME")
            var checkWordTime: String? = null,

            @Expose
            @SerializedName("IS_ONLINE")
            var isOnline: String? = null,

            @Expose
            @SerializedName("TOKEN")
            var token: String? = null,

            @Expose
            @SerializedName("UF_IS_RATE")
            var ufIsRate: Long? = null,

            @Expose
            @SerializedName("USER_GROUP")
            var userGroup: String? = null
)