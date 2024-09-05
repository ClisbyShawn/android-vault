package com.clisbyshawn.vault.common.domain.os.impl

object IvPersistence {
    private val mapIv = mutableMapOf<String, ByteArray>()

    fun saveIv(byteArray: ByteArray) {
        mapIv["iv"] = byteArray
    }

    fun getIv(): ByteArray? {
        return mapIv["iv"]
    }

}