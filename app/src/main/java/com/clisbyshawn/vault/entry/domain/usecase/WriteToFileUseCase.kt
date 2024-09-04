package com.clisbyshawn.vault.entry.domain.usecase

import android.util.Log
import com.clisbyshawn.vault.common.domain.Constants
import java.io.FileOutputStream
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WriteToFileUseCase @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(directoryPath: String, text: String) {
        withContext(ioDispatcher) {
            try {
                val filePath = "$directoryPath/${Constants.encryptionFileName}"
                FileOutputStream(filePath, true)
                    .bufferedWriter()
                    .use {
                        it.write(text)
                        it.newLine()
                    }
            } catch (io: Exception) {
                Log.e("shawn clisby", "invoke: failed write", io)
            }
        }
    }
}