package com.clisbyshawn.vault.vault.di

import com.clisbyshawn.vault.vault.domain.usecase.ReadFromFileUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TheVaultModule {


    @ViewModelScoped
    @Provides
    fun providesReadFromFileUseCase(): ReadFromFileUseCase {
        return ReadFromFileUseCase()
    }
}