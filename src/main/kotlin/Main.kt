// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    MetaData()

    Window(
        onCloseRequest = ::exitApplication,
        title = MetaData.windowTitle,
        state = WindowState(
            size = DpSize(MetaData.windowWidth.dp, MetaData.windowHeight.dp),
            position = WindowPosition(Alignment.Center)
        ),
        icon = painterResource(resourcePath = MetaData.appKnightImage),
        resizable = false
    ) {
        App()
    }
}
