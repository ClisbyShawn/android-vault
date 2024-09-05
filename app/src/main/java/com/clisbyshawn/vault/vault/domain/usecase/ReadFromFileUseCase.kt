package com.clisbyshawn.vault.vault.domain.usecase

import android.util.Log
import com.clisbyshawn.vault.common.domain.Constants
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ReadFromFileUseCase @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(directoryPath: String): ByteArray? = withContext(ioDispatcher) {
        return@withContext try {
            val file = File("$directoryPath/${Constants.INTERNAL_FILE_NAME}")
            FileInputStream(file)
                .use {
                    it.readBytes()
                }
        } catch (io: IOException) {
            Log.e("shawn clisby", "invoke: failed read", io)
            null
        }
    }
}