package ru.techmas.magicmirror.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginRequest {
    data class ServerLoginRequest internal constructor(@Expose
                                                       @SerializedName ("login") internal val login: String,

                                                       @Expose
                                                       @SerializedName ("password") internal val password: String)

}