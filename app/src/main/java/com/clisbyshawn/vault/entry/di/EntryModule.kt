package com.clisbyshawn.vault.entry.di

import com.clisbyshawn.vault.entry.domain.usecase.WriteToFileUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object EntryModule {

    @ViewModelScoped
    @Provides
    fun providesWriteToFileUseCase(): WriteToFileUseCase {
        return WriteToFileUseCase()
    }
}