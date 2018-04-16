package ru.techmas.magicmirror.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterRequest {
    data class ServerRegisterRequest internal constructor(
            @Expose
            @SerializedName("login") internal val login: String,

            @Expose
            @SerializedName("password") internal val password: String,

            @Expose
            @SerializedName("email") internal val email: String,

            @Expose
            @SerializedName("name") internal val name: String,

            @Expose
            @SerializedName("last_name") internal val lastName: String,

            @Expose
            @SerializedName("city_id") internal val cityID: String,

            @Expose
            @SerializedName("birthday") internal val birthday: String,

            @Expose
            @SerializedName("gender") internal val gender: String,

            @Expose
            @SerializedName("is_rate") internal val is_rate: String

    )
}