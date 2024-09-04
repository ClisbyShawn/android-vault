package com.clisbyshawn.vault.vault.domain.usecase

import android.util.Log
import com.clisbyshawn.vault.common.domain.Constants
import java.io.FileInputStream
import java.io.IOException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ReadFromFileUseCase(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(directoryPath: String): List<String>? {
        withContext(ioDispatcher) {
            try {
                val filePath = "$directoryPath/${Constants.encryptionFileName}"
                FileInputStream(filePath)
                    .bufferedReader()
                    .use {
                        it.readLines()
                    }
            } catch (io: IOException) {
                Log.e("shawn clisby", "invoke: failed read", io)
                null
            }
        }
    }
}