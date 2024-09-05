package com.clisbyshawn.vault.common.di

import com.clisbyshawn.vault.common.domain.os.ICipherHandler
import com.clisbyshawn.vault.common.domain.os.IKeyHandler
import com.clisbyshawn.vault.common.domain.usecase.DecryptByteArrayUseCase
import com.clisbyshawn.vault.common.domain.usecase.EncryptTextUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun providesDecryptByteArrayUseCase(
        keyHandler: IKeyHandler,
        cipherHandler: ICipherHandler
    ): DecryptByteArrayUseCase {
        return DecryptByteArrayUseCase(
            keyHandler, cipherHandler
        )
    }


    @ViewModelScoped
    @Provides
    fun providesEncryptTextUseCase(
        keyHandler: IKeyHandler,
        cipherHandler: ICipherHandler
    ): EncryptTextUseCase {
        return EncryptTextUseCase(
            keyHandler, cipherHandler
        )
    }
}