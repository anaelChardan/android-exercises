package fr.android.achardan.book.domain.processor

import android.os.Parcelable
import fr.android.achardan.book.domain.model.Book
import fr.android.achardan.generic.processor.ItemProcessor

interface BookProcessor : ItemProcessor<Book>, Parcelable