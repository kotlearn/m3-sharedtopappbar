package com.kotlearn.sharedtopappbar

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kotlearn Shared TopAppBar",
    ) {
        App()
    }
}