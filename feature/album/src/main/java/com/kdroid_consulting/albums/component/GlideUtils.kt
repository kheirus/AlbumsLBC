package com.kdroid_consulting.albums.component

import com.bumptech.glide.load.model.GlideUrl

internal fun String.toUrlWithHeader()= GlideUrl(this) { mapOf("User-Agent" to "Android")}

