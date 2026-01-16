package com.spoons.popparazzi.core.network.api

import com.spoons.popparazzi.core.config.NetworkConfig
import com.spoons.popparazzi.core.network.dto.UserDto
import retrofit2.http.GET

interface UserApi {
    @GET(NetworkConfig.User.GET_USER)
    suspend fun getUser(): UserDto
}