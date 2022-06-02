package com.matheus.mota.minenotes.common.extentions

import com.matheus.mota.minenotes.R


enum class IntentValues(val get: String) {
    NOTE_DATA("NOTE_DATA")
}


enum class Color{
    PURPLE,
    RED,
    YELLOW,
    GREEN,
    BLUE
}

fun setColor(color: Color): Int{
    return when(color){
        Color.PURPLE -> {
            R.color.card_purple_color
        }
        Color.RED -> {
            R.color.card_pastel_red_color
        }
        Color.YELLOW -> {
            R.color.card_pastel_yellow_color
        }
        Color.GREEN -> {
            R.color.card_light_green_color
        }
        Color.BLUE -> {
            R.color.card_light_blue_color
        }
    }
}