package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_library.*
import android.view.LayoutInflater
import android.support.v7.widget.GridLayoutManager
import java.util.*


class LibraryActivity : AppCompatActivity() {

    private val RANDOM = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        bookListView.layoutManager = GridLayoutManager(this, 2)
        bookListView.adapter = RecyclerAdapter(LayoutInflater.from(this), getBooks(), R.layout.custom_view_item_book)
    }

    private fun getBooks(): List<Book> {
        return (0..99).map { i -> Book("Garry Potier Tom $i", RANDOM.nextFloat()) }
    }
}
