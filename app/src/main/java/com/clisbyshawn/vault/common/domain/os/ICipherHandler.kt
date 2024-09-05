package com.clisbyshawn.vault.common.domain.os

import javax.crypto.Cipher
import javax.crypto.SecretKey

interface ICipherHandler {

    fun getEncryptionCipher(secretKey: SecretKey): Cipher
    fun getDecryptionCipher(secretKey: SecretKey, iv: ByteArray): Cipher
}