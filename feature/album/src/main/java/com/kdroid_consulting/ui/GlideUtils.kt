package com.kdroid_consulting.ui

import com.bumptech.glide.load.model.GlideUrl

internal fun String.toUrlWithHeader()= GlideUrl(this) { mapOf("User-Agent" to "Android")}

