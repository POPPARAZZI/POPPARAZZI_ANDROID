package com.spoons.popparazzi.core.data.mapper

import com.spoons.popparazzi.core.database.entity.UserEntity
import com.spoons.popparazzi.core.domain.model.User
import com.spoons.popparazzi.core.network.dto.UserDto

fun UserDto.toEntity() = UserEntity(id = id, name = name)
fun UserEntity.toDomain() = User(id = id, name = name)