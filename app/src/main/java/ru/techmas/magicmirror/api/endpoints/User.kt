package ru.techmas.magicmirror.api.endpoints

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.models.UserDTO

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

interface User {

    @GET("app/user/author")
    fun login(@Query("login") login: String,
              @Query("password") password: String): Observable<ApiResponse<UserDTO>>

    @POST("app/user/reg")
    fun registration(@Body user: UserDTO): Observable<ApiResponse<UserDTO>>

}
