package fr.android.achardan.supportingboundedcontext.persistence

import android.os.Parcelable

interface ItemProcessor<T>: Parcelable {
    fun process(processFunction: (List<T>) -> Unit, onError: (Throwable) -> Unit)
}