package ru.techmas.magicmirror.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
 {
                "ID": "47",
                "TIMESTAM       P_X": "18.04.2018 17:04:15",
                "LOGIN": "9038899000",
                "PASSWORD": "dSVcffB87a1ac76a58f85537b6f4f333dd6b913d",
                "CHECKWORD": "jpgsr7Yzea731e9576f559fb076841ce5828627f",
                "ACTIVE": "Y",
                "NAME": "Оксана",
                "LAST_NAME": "Дугинова",
                "EMAIL": "test20@mail.ru",
                "LAST_LOGIN": "23.04.2018 15:02:49",
                "DATE_REGISTER": "26.03.2018 12:14:15",
                "LID": "ru",
                "PERSONAL_MOBILE": "+7(903)889-90-00",
                "PERSONAL_CITY": "Москва",
                "PERSONAL_BIRTHDAY": "13.04.1944",
                "CHECKWORD_TIME": "2018-04-13 12:47:59",
                "IS_ONLINE": "N",
                "TOKEN": "NGVjRnZxq0D91fCzd3kSsgTL38NzZrVM7Q4Yc3vD3",
                "UF_IS_RATE": "1",
                "UF_CITY_ID": "234"
            }
 */
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

        @SerializedName("PERSONAL_MOBILE")
        var userMobile: String? = null,

        @SerializedName("PERSONAL_CITY")
        var userCity: String? = null,

        @SerializedName("PERSONAL_BIRTHDAY")
        var userBirhday: String? = null,

        @SerializedName("CHECKWORD_TIME")
        var checkWordTime: String? = null,

        @SerializedName("IS_ONLINE")
        var isOnline: String? = null,

        @SerializedName("TOKEN")
        var token: String? = null,

        @SerializedName("UF_IS_RATE")
        var ufIsRate: Long? = null,

        @SerializedName("UF_CITY_ID")
        var ufCityId: Long? = null



//        @SerializedName("USER_GROUP")
//        var userGroup: String? = null
)