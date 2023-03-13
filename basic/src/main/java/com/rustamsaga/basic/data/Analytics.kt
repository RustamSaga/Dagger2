package com.rustamsaga.basic.data

import javax.inject.Inject

class Analytics @Inject constructor() {

    fun trackScreenShow() {}

    fun trackNewsRequest(newsId: String){}
}