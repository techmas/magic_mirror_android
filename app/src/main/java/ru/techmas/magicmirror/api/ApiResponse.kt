package ru.techmas.magicmirror.api

import com.google.gson.annotations.SerializedName

/**
{
"status": "error",
"status_code": 0,
"status_msg": "Ошибка регистрации",
"error_msg": [
"Укажите ID города"
]
}
 */

class ApiResponse<T> {
    var status: String? = null
    @SerializedName("status_code")
    var statusCode: String? = null
    @SerializedName("status_msg")
    var statusMsg: String? = null
    @SerializedName("error_msg")
    var errorMsg: String? = null
    @SerializedName("data")
    var data: T? = null
        private set

    fun setDate(data: T) {
        this.data = data
    }
}
