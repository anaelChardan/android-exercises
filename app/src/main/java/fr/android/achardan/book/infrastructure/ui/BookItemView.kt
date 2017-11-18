package fr.android.achardan.book.infrastructure.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import fr.android.achardan.book.domain.model.Book
import fr.android.achardan.supportingboundedcontext.ui.ItemView
import kotlinx.android.synthetic.main.book_view_list.view.*


class BookItemView: LinearLayout, ItemView<Book> {
    var currentBook: Book? = null

    constructor(context: Context?): super(context)
    constructor(context: Context?, attrs: AttributeSet?): super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr)


    override fun bind(book: Book): View {
        currentBook = book

        titleTextView.text = book.title

        book.cover?.let {
            Glide.with(context).load(it).into(imageBook)
        }

        return this
    }
}
