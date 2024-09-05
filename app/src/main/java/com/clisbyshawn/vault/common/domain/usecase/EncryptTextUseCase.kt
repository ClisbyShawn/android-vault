package com.clisbyshawn.vault.common.domain.usecase

import com.clisbyshawn.vault.common.domain.os.ICipherHandler
import com.clisbyshawn.vault.common.domain.os.IKeyHandler
import com.clisbyshawn.vault.common.domain.os.impl.IvPersistence
import javax.inject.Inject

class EncryptTextUseCase @Inject constructor(
    private val keyHandler: IKeyHandler,
    private val cipherHandler: ICipherHandler,
) {

    operator fun invoke(stringToEncrypt: String): ByteArray {
        val byteText = stringToEncrypt.encodeToByteArray()

        val secretKey = keyHandler.createOrGetEncryptionKey()

        val cipher = cipherHandler.getEncryptionCipher(secretKey)
        IvPersistence.saveIv(cipher.iv)
        val cipherText = cipher.doFinal(byteText)
        return cipherText
    }
}