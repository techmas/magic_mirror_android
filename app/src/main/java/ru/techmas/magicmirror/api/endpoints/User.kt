package ru.techmas.magicmirror.api.endpoints

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.techmas.magicmirror.api.models.ApiResponse
import ru.techmas.magicmirror.api.models.HashResponse
import ru.techmas.magicmirror.api.models.PhotoDTO
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
    fun registration(@Query("login") login: String,
                     @Query("password") password: String,
                     @Query("email") email: String,
                     @Query("name") name: String,
                     @Query("last_name") lastName: String): Observable<ApiResponse<String>>

    @POST("/app/user/get_user")
    fun getPhoto(@Query("token") token: String,
                 @Query("user_id") username: String): Observable<ApiResponse<HashResponse<PhotoDTO>>>

    @POST("/app/user/is_logged")
    fun getProfile(@Query("token") token: String): Observable<ApiResponse<UserDTO>>

    @POST("/app/user/update/")
    fun updateProfile(@Body user: UserDTO) : Observable<ApiResponse<UserDTO>>

    @GET("app/user/forgot_password")
    fun sendRecovery(@Query("search_data") date: String): Observable<ApiResponse<String>>

    @GET("app/user/forgot_password")
    fun checkRecovery(@Query("checkword") date: String,
                      @Query("password") password: String,
                      @Query("confirm_password") confirm: String): Observable<ApiResponse<String>>

}
