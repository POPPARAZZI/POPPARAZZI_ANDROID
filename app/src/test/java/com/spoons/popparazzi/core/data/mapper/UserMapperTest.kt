package com.spoons.popparazzi.core.data.mapper

import com.spoons.popparazzi.core.database.entity.UserEntity
import com.spoons.popparazzi.core.domain.model.User
import com.spoons.popparazzi.core.network.dto.UserDto
import org.junit.Assert.assertEquals
import org.junit.Test

class UserMapperTest {
    @Test
    fun `UserDto toEntity`() {
        val dto = UserDto(id = "1", name = "kim")

        val entity = dto.toEntity()

        assertEquals(UserEntity(id = "1", name = "kim"), entity)
    }

    @Test
    fun `UserEntity toDomain`() {
        val entity = UserEntity(id = "2", name = "lee")

        val domain = entity.toDomain()

        assertEquals(User(id = "2", name = "lee"), domain)
    }
}