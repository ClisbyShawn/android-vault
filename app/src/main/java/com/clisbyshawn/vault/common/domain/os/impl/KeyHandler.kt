package com.clisbyshawn.vault.common.domain.os.impl

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.security.keystore.KeyProperties.PURPOSE_DECRYPT
import android.security.keystore.KeyProperties.PURPOSE_ENCRYPT
import com.clisbyshawn.vault.common.domain.Constants.AES
import com.clisbyshawn.vault.common.domain.Constants.KEY_PROVIDER
import com.clisbyshawn.vault.common.domain.Constants.KEY_STORE_ALIAS
import com.clisbyshawn.vault.common.domain.os.IKeyHandler
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class KeyHandler : IKeyHandler {

    override fun createOrGetEncryptionKey(): SecretKey {
        return loadKeyStore().getKey(KEY_STORE_ALIAS, null) as? SecretKey ?: run {

            val parameterSpecification = KeyGenParameterSpec.Builder(
                KEY_STORE_ALIAS,
                PURPOSE_ENCRYPT or PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                .setUserAuthenticationRequired(false)
                .setRandomizedEncryptionRequired(true)
                .build()


            val keyGenerator = KeyGenerator.getInstance(AES, KEY_PROVIDER)
            keyGenerator.init(parameterSpecification)
            keyGenerator.generateKey()
        }
    }

    override fun getDecryptionKey(): SecretKey? {
        return loadKeyStore().getKey(KEY_STORE_ALIAS, null) as? SecretKey
    }


    private fun loadKeyStore(): KeyStore {
        return KeyStore.getInstance(KEY_PROVIDER).apply {
            load(null)
        }
    }
}