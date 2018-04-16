package ru.techmas.magicmirror.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(@Expose
                         @SerializedName("status")
                         var status: String? = null,

                         @Expose
                         @SerializedName("status_code")
                         var status_code: String? = null,

                         @Expose
                         @SerializedName("status_msg")
                         var status_msg: String? = null,

                         @Expose
                         @SerializedName("DTO")
                         var DTO: UserDTO? = null
)