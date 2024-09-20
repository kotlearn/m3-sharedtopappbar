package com.kotlearn.sharedtopappbar

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data object CatList

    @Serializable
    data class CatDetail(val id: Int)

}
