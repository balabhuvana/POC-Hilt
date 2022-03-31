package com.learn.poc_hilt.repo

import com.learn.poc_hilt.network.ApiWebService
import kotlinx.coroutines.flow.flow

class MainRepository(var apiWebService: ApiWebService) {

    suspend fun fetch() =
        flow {
            emit(apiWebService.fetchUserList())
        }

}