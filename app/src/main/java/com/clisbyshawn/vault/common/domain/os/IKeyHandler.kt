package com.clisbyshawn.vault.common.domain.os


import javax.crypto.SecretKey

interface IKeyHandler {
    fun createOrGetEncryptionKey(): SecretKey
    fun getDecryptionKey(): SecretKey?
}