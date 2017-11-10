package fr.android.androidexercises

import android.view.View

interface ItemView<in T> {
    fun bind(t: T): View
}