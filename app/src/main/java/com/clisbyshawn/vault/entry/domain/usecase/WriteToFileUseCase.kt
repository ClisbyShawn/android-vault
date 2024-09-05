package com.clisbyshawn.vault.entry.domain.usecase

import android.util.Log
import com.clisbyshawn.vault.common.domain.Constants.INTERNAL_FILE_NAME
import com.clisbyshawn.vault.common.domain.usecase.EncryptTextUseCase
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WriteToFileUseCase @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val encryptTextUseCase: EncryptTextUseCase
) {

    suspend operator fun invoke(directoryPath: String, text: String) {
        withContext(ioDispatcher) {
            try {
                val cipherText = encryptTextUseCase.invoke(stringToEncrypt = text)
                val file = File(directoryPath, INTERNAL_FILE_NAME)
                if (file.exists().not()) {
                    file.createNewFile()
                }
                FileOutputStream(file)
                    .use {
                        it.write(cipherText)
                    }
            } catch (io: Exception) {
                Log.e("shawn clisby", "invoke: failed write", io)
            }
        }
    }
}