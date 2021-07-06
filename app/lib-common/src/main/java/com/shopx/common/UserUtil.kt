package com.shopx.common

import android.content.Context
import android.os.Environment
import java.io.File

object UserUtil {

    const val LOG_FOLDER_NAME = "logs"

    fun appLogFolder(context: Context): File? {
        var folder: File? =
            File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), LOG_FOLDER_NAME)
        if (!folder!!.exists() && !folder.mkdirs()) folder = null
        return folder
    }

    fun appLogFolderPath(context: Context): String {
        val folder = appLogFolder(context)
        return if (folder != null && folder.exists()) folder.absolutePath else ""
    }

    fun logFilePath(context: Context, name: String): String {
        val folder = appLogFolder(context)
        return if (folder != null && !folder.exists() && !folder.mkdir()) "" else File(
            folder,
            name
        ).absolutePath
    }
}
