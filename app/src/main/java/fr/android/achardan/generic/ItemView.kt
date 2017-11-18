package fr.android.achardan.generic

import android.view.View

interface ItemView<in T> {
    fun bind(t: T): View
}