package ru.techmas.magicmirror.api.endpoints

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.models.PhotoDTO
import ru.techmas.magicmirror.models.Photos

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

interface Photo {

    @GET("/app/photo/rate_photo")
    fun getPhoto(@Query("token") token: String,
              @Query("bh_from") bh_from: String,
              @Query("bh_to") bh_to: String,
              @Query("city") city: String): Observable<ApiResponse<Photos>>

}
