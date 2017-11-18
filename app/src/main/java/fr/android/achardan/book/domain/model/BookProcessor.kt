package fr.android.achardan.book.domain.model

import android.os.Parcelable
import fr.android.achardan.supportingboundedcontext.persistence.ItemProcessor

interface BookProcessor : ItemProcessor<Book>, Parcelable