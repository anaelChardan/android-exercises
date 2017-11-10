package fr.android.androidexercises

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.custom_view_item_book.view.*


class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {

    private var name: TextView? = null
    private var price: TextView? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        name = nameTextView
        price = priceTextView
    }

    fun bind(book: Book): View {
        name!!.text = book.name
        price!!.text = book.price.toString()

        return this
    }
}