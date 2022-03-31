package com.learn.poc_hilt.network

import com.learn.poc_hilt.UserListRoot
import retrofit2.http.GET

interface ApiWebService {

    @GET("api/users?page=2")
    suspend fun fetchUserList(): UserListRoot

}
