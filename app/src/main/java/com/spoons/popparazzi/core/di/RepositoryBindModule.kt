package com.spoons.popparazzi.core.di

import com.spoons.popparazzi.core.data.repository.UserRepositoryImpl
import com.spoons.popparazzi.core.domain.interactor.user.GetUserUseCaseImpl
import com.spoons.popparazzi.core.domain.interactor.user.UserUseCasesImpl
import com.spoons.popparazzi.core.domain.repository.UserRepository
import com.spoons.popparazzi.core.domain.usecase.user.GetUserUseCase
import com.spoons.popparazzi.core.domain.usecase.user.UserUseCases
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    // todo
    @Binds
    @Singleton
    abstract fun bindUserUserCases(impl: UserUseCasesImpl): UserUseCases

    @Binds
    @Singleton
    abstract fun bindGetUserUseCase(impl: GetUserUseCaseImpl): GetUserUseCase

}