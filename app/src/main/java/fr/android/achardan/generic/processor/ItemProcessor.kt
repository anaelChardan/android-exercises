package fr.android.achardan.generic.processor

import android.os.Parcelable

interface ItemProcessor<T>: Parcelable {
    fun process(processFunction: (List<T>) -> Unit, onError: (Throwable) -> Unit)
}