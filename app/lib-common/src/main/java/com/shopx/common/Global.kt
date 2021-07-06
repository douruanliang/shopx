package com.shopx.common

import android.graphics.Color

class Global {
    object Constants {
        const val ROLE_AUDIENCE = 0
        const val ROLE_HOST = 1
        const val ROLE_OWNER = 2
        // Shared reference keys
        const val SF_NAME = "sf-agora-live"
        const val KEY_BEAUTY_ENABLED = "key-beauty-enabled"
        const val KEY_BLUR = "key-blur"
        const val KEY_WHITEN = "key-whiten"
        const val KEY_CHEEK = "key-cheek"
        const val KEY_EYE = "key-eye"
        const val KEY_RESOLUTION = "key-resolution"
        const val KEY_FRAME_RATE = "key-framerate"
        const val KEY_BITRATE = "key-bitrate"
        const val TAB_KEY = "live-tab"
        const val TAB_ID_MULTI = 0
        const val TAB_ID_SINGLE = 1
        const val TAB_ID_PK = 2
        const val TAB_ID_VIRTUAL = 3
        const val TAB_ECOMMERCE = 4
        const val KEY_ROOM_ID = "room-id"
        const val KEY_ROOM_NAME = "room-name"
        const val KEY_IS_ROOM_OWNER = "is-room-owner"
        const val KEY_ROOM_OWNER_ID = "room-owner-id"
        const val KEY_CREATE_ROOM = "create-room"
        const val KEY_VIRTUAL_IMAGE = "virtual-image"
        const val KEY_PEER_ID = "peer-id"
        const val KEY_NICKNAME = "nick-name"
        const val KEY_AUDIENCE_VIRTUAL_IMAGE = "audience-select-image"
        const val KEY_PROFILE_UID = "key-profile-uid"
        const val KEY_USER_NAME = "key-user-name"
        const val KEY_IMAGE_URL = "key-image-url"
        const val KEY_TOKEN = "key-token"
        const val EDIT_USER_NAME_RESULT_CANCEL = 1
        const val EDIT_USER_NAME_RESULT_DONE = 2
        val DIVIDER_COLOR = Color.rgb(239, 239, 239)
        const val VIDEO_MAX_BITRATE = 2000
        const val VIDEO_MIN_BITRATE = 0
        const val VIDEO_DEFAULT_RESOLUTION_INDEX = 0
        const val VIDEO_DEFAULT_FRAME_RATE_INDEX = 0
        const val CAMERA_CAPTURE_WIDTH = 1920
        const val CAMERA_CAPTURE_HEIGHT = 1080
        const val CAMERA_FRAME_RATE = 30

        // By default the app log keeps for 5 days before being destroyed
        const val LOG_DURATION = (1000 * 60 * 24 * 5).toLong()
        // Enable stack trace info with depth
        const val LOG_CLASS_DEPTH = 1
        const val APP_LOG_SIZE = (1 shl 30).toLong()
        const val VOICE_INDICATE_INTERVAL = 1500
        const val VOICE_INDICATE_SMOOTH = 3

    }
}