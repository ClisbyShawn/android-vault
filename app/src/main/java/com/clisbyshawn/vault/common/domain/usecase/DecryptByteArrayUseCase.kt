package com.clisbyshawn.vault.common.domain.usecase

import com.clisbyshawn.vault.common.domain.os.ICipherHandler
import com.clisbyshawn.vault.common.domain.os.IKeyHandler
import com.clisbyshawn.vault.common.domain.os.impl.IvPersistence
import javax.inject.Inject

class DecryptByteArrayUseCase @Inject constructor(
    private val keyHandler: IKeyHandler,
    private val cipherHandler: ICipherHandler,
) {
    operator fun invoke(encryptedText: ByteArray): ByteArray? {
        val secretKey = keyHandler.getDecryptionKey() ?: return null

        val iv = IvPersistence.getIv() ?: run {
            ByteArray(16)
        }
        val cipher = cipherHandler.getDecryptionCipher(secretKey, iv)
        return cipher.doFinal(encryptedText)
    }
}