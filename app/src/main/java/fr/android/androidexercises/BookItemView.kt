package fr.android.androidexercises

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_view_item_book.view.*

class BookItemView: LinearLayout, ItemView<Book> {
    constructor(context: Context?): super(context)
    constructor(context: Context?, attrs: AttributeSet?): super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun bind(t: Book): View {
        nameTextView.text = t.name
        priceTextView.text = t.price.toString()

        return this
    }
}