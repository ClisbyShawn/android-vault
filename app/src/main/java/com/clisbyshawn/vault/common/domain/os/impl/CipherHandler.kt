package com.clisbyshawn.vault.common.domain.os.impl

import com.clisbyshawn.vault.common.domain.Constants.TRANSFORMATION_CIPHER
import com.clisbyshawn.vault.common.domain.os.ICipherHandler
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

class CipherHandler : ICipherHandler {

    override fun getEncryptionCipher(secretKey: SecretKey): Cipher {
        return Cipher.getInstance(TRANSFORMATION_CIPHER)
            .apply { init(Cipher.ENCRYPT_MODE, secretKey) }
    }

    override fun getDecryptionCipher(secretKey: SecretKey, iv: ByteArray): Cipher {
        return Cipher.getInstance(TRANSFORMATION_CIPHER)
            .apply { init(Cipher.DECRYPT_MODE, secretKey, IvParameterSpec(iv)) }
    }
}