package com.example.newsapp.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Add_home: ImageVector
    get() {
        if (_Add_home != null) return _Add_home!!

        _Add_home = ImageVector.Builder(
            name = "Add_home",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(700f, 760f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(-100f)
                horizontalLineToRelative(100f)
                verticalLineToRelative(-40f)
                horizontalLineTo(740f)
                verticalLineToRelative(-100f)
                horizontalLineToRelative(-40f)
                verticalLineToRelative(100f)
                horizontalLineTo(600f)
                verticalLineToRelative(40f)
                horizontalLineToRelative(100f)
                close()
                moveToRelative(20f, 80f)
                quadToRelative(-83f, 0f, -141.5f, -58.5f)
                reflectiveQuadTo(520f, 640f)
                reflectiveQuadToRelative(58.5f, -141.5f)
                reflectiveQuadTo(720f, 440f)
                reflectiveQuadToRelative(141.5f, 58.5f)
                reflectiveQuadTo(920f, 640f)
                reflectiveQuadToRelative(-58.5f, 141.5f)
                reflectiveQuadTo(720f, 840f)
                moveToRelative(-560f, -80f)
                verticalLineToRelative(-480f)
                lineToRelative(320f, -240f)
                lineToRelative(320f, 240f)
                verticalLineToRelative(92f)
                quadToRelative(-19f, -6f, -39f, -9f)
                reflectiveQuadToRelative(-41f, -3f)
                verticalLineToRelative(-40f)
                lineTo(480f, 140f)
                lineTo(240f, 320f)
                verticalLineToRelative(360f)
                horizontalLineToRelative(203f)
                quadToRelative(3f, 21f, 9f, 41f)
                reflectiveQuadToRelative(15f, 39f)
                close()
                moveToRelative(320f, -350f)
            }
        }.build()

        return _Add_home!!
    }

private var _Add_home: ImageVector? = null

