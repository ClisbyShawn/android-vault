package com.clisbyshawn.vault.common.di

import com.clisbyshawn.vault.common.domain.os.ICipherHandler
import com.clisbyshawn.vault.common.domain.os.IKeyHandler
import com.clisbyshawn.vault.common.domain.os.impl.CipherHandler
import com.clisbyshawn.vault.common.domain.os.impl.KeyHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OsModule {

    @Singleton
    @Provides
    fun providesKeyHandler(): IKeyHandler {
        return KeyHandler()
    }

    @Singleton
    @Provides
    fun providesCipherHandler(): ICipherHandler {
        return CipherHandler()
    }
}