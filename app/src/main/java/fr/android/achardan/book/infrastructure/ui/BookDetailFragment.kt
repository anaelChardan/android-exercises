package fr.android.achardan.book.infrastructure.ui

import android.os.Bundle
import com.bumptech.glide.Glide
import fr.android.achardan.book.domain.model.Book
import fr.android.achardan.generic.fragment.AbstractDetailedFragment
import fr.android.achardan.generic.fragment.DetailFragment
import kotlinx.android.synthetic.main.book_view_full.*

class BookDetailFragment: DetailFragment, AbstractDetailedFragment<Book>() {
    override fun bindObjectToView() {
        this.currentItem?.let {
            details_titleTextView?.text = it.title
            details_priceTextView?.text = it.price
            details_isbnTextView?.text = it.isbn
            Glide
                    .with(this)
                    .load(it.cover)
                    .into(details_coverImageView)
        }
    }

    companion object {
        fun create(
                book: Book,
                layoutId: Int
        ): BookDetailFragment {
            val bookDetailFragment = BookDetailFragment()

            val bundle = Bundle()

            bundle.putParcelable(DetailFragment.PARCELABLE_OBJECT_KEY, book)
            bundle.putInt(DetailFragment.DETAIL_VIEW_ID_KEY, layoutId)

            bookDetailFragment.arguments = bundle

            return bookDetailFragment
        }
    }
}