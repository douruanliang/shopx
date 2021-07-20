package com.shopx

import android.app.Application
import com.elvishew.xlog.LogConfiguration
import com.elvishew.xlog.LogLevel
import com.elvishew.xlog.XLog
import com.elvishew.xlog.flattener.PatternFlattener
import com.elvishew.xlog.formatter.message.json.DefaultJsonFormatter
import com.elvishew.xlog.formatter.message.throwable.DefaultThrowableFormatter
import com.elvishew.xlog.formatter.message.xml.DefaultXmlFormatter
import com.elvishew.xlog.formatter.stacktrace.DefaultStackTraceFormatter
import com.elvishew.xlog.formatter.thread.DefaultThreadFormatter
import com.elvishew.xlog.printer.AndroidPrinter
import com.elvishew.xlog.printer.Printer
import com.elvishew.xlog.printer.file.FilePrinter
import com.elvishew.xlog.printer.file.backup.FileSizeBackupStrategy
import com.elvishew.xlog.printer.file.clean.FileLastModifiedCleanStrategy
import com.elvishew.xlog.printer.file.naming.DateFileNameGenerator
import com.shopx.common.Global
import com.shopx.net.HttpApiBase

class ShopxApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        HttpApiBase.init(this)

    }


    fun initXLog() {
        val config = LogConfiguration.Builder()
            .logLevel(if (BuildConfig.DEBUG) LogLevel.DEBUG else LogLevel.INFO) // Specify log level, logs below this level won't be printed, default: LogLevel.ALL
            .tag("AgoraLive") // Specify TAG, default: "X-LOG"
            //.t()                                                            // Enable thread info, disabled by default
            .st(Global.Constants.LOG_CLASS_DEPTH) // Enable stack trace info with depth 2, disabled by default
            // .b()                                                            // Enable border, disabled by default
            .jsonFormatter(DefaultJsonFormatter()) // Default: DefaultJsonFormatter
            .xmlFormatter(DefaultXmlFormatter()) // Default: DefaultXmlFormatter
            .throwableFormatter(DefaultThrowableFormatter()) // Default: DefaultThrowableFormatter
            .threadFormatter(DefaultThreadFormatter()) // Default: DefaultThreadFormatter
            .stackTraceFormatter(DefaultStackTraceFormatter()) // Default: DefaultStackTraceFormatter
            .build()
        val androidPrinter: Printer =
            AndroidPrinter() // Printer that print the log using android.util.Log
        val flatPattern = "{d yy/MM/dd HH:mm:ss} {l}|{t}: {m}"
        val filePrinter: Printer =
            FilePrinter.Builder("shopx_log") // Specify the path to save log file
                .fileNameGenerator(DateFileNameGenerator()) // Default: ChangelessFileNameGenerator("log")
                .backupStrategy(
                    FileSizeBackupStrategy(
                        Global.Constants.APP_LOG_SIZE
                    )
                ) // Default: FileSizeBackupStrategy(1024 * 1024)
                .cleanStrategy(
                    FileLastModifiedCleanStrategy(
                        Global.Constants.LOG_DURATION
                    )
                )
                .flattener(PatternFlattener(flatPattern)) // Default: DefaultFlattener
                .build()
        XLog.init( // Initialize XLog
            config,  // Specify the log configuration, if not specified, will use new LogConfiguration.Builder().build()
            androidPrinter,
            filePrinter
        )
    }


}