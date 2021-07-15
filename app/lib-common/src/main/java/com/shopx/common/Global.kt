package com.shopx.common

class Global {
    object Constants {
        const val ROLE_AUDIENCE = 0
        const val ROLE_HOST = 1
        const val ROLE_OWNER = 2

        // Shared reference keys
        const val KEY_BEAUTY_ENABLED = "key-beauty-enabled"
        const val KEY_BLUR = "key-blur"

        // By default the app log keeps for 5 days before being destroyed
        const val LOG_DURATION = (1000 * 60 * 24 * 5).toLong()

        // Enable stack trace info with depth
        const val LOG_CLASS_DEPTH = 1
        const val APP_LOG_SIZE = (1 shl 30).toLong()

    }
}