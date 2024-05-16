package br.com.lucascordeiro.mvvm_mvi.presentation.utils

import java.util.*

fun String.capitalize(): String {
    return replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
}